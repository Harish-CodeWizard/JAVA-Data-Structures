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
