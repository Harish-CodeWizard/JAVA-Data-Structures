package DS.Tree_DS;

class Node {
    int val, ht;
    Node left, right;

    Node(int d) {
        val = d;
        ht = 0;
        left = null;
        right = null;
    }
}

public class AVL_Tree {
    Node root;

    AVL_Tree(int val) {
        root = new Node(val);
    }

    public void delete(int key) {
        root = deleteNode(root, key);
    }


    Node deleteNode(Node root, int key) {
        if (root == null) return root;

        // BST delete
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node to delete found
            if (root.left == null || root.right == null) {
                Node temp = null;
                if (root.left != null) temp = root.left;
                else if (root.right != null) temp = root.right;

                if (temp == null) {
                    // No child
                    root = null;
                } else {
                    // One child
                    root = temp;
                }
            } else {
                // Two children: get inorder successor
                Node temp = minValueNode(root.right);
                root.val = temp.val;
                root.right = deleteNode(root.right, temp.val);
            }
        }

        if (root == null) return root;

        // Update height
        root.ht = Math.max(height(root.left), height(root.right)) + 1;

        // Get balance factor
        int balancefact = height(root.left) - height(root.right);

        // LL
        if (balancefact > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // LR
        if (balancefact > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // RR
        if (balancefact < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // RL
        if (balancefact < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    int getBalance(Node n) {
        if (n == null) return 0;
        return height(n.left) - height(n.right);
    }

    Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }



    // Insert wrapper
    public void insert(int v) {
        root = helper(root, v);
    }

    // Recursive helper
    public Node helper(Node n, int v) {
        if (n == null) return new Node(v);

        if (v < n.val) {
            n.left = helper(n.left, v);
        } else if (v > n.val) {
            n.right = helper(n.right, v);
        } else {
            return n; // no duplicates
        }

        n.ht = Math.max(height(n.left), height(n.right)) + 1;

        int balancefact = height(n.left) - height(n.right);

        // LL
        if (balancefact > 1 && v < n.left.val)
            return rightRotate(n);

        // LR
        if (balancefact > 1 && v > n.left.val) {
            n.left = leftRotate(n.left);
            return rightRotate(n);
        }

        // RR
        if (balancefact < -1 && v > n.right.val)
            return leftRotate(n);

        // RL
        if (balancefact < -1 && v < n.right.val) {
            n.right = rightRotate(n.right);
            return leftRotate(n);
        }

        return n;
    }

    // Right rotate
    Node rightRotate(Node z) {
        Node y = z.left;
        Node T2 = y.right;

        y.right = z;
        z.left = T2;

        z.ht = Math.max(height(z.left), height(z.right)) + 1;
        y.ht = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Left rotate
    Node leftRotate(Node x) {
        Node y = x.right;
        Node temp = y.left;

        y.left = x;
        x.right = temp;

        x.ht = Math.max(height(x.left), height(x.right)) + 1;
        y.ht = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Get height of a node
    public int height(Node n) {
        if (n == null) return -1;
        return n.ht;
    }

    // In-order traversal
    void inorderTraversal(Node root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        AVL_Tree avl = new AVL_Tree(50);
        avl.insert(10);
        avl.insert(5);
        avl.insert(3);
        avl.insert(4);
        avl.insert(100);
        avl.insert(75);

        System.out.println("In-order traversal of AVL tree:");
        avl.inorderTraversal(avl.root);
    }
}
