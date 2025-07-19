package DS.Tree_DS;

import java.util.LinkedList;
import java.util.Queue;

// class Node {
//     int val;
//     Node left, right;

//     Node(int val) {
//         this.val = val;
//     }
// }

public class BinaryTree {
    Node root;

    BinaryTree(int val) {
        root = new Node(val);
    }

    void insertLeft(Node node, int val) {
        Node newNode = new Node(val);
        node.left = newNode;
    }

    void insertRight(Node node, int val) {
        Node newNode = new Node(val);
        node.right = newNode;
    }

    void preOrderTraversal(Node root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    void preOrderTraversalIterative(Node node) {
        if (node == null) {
            return;
        }
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(node);
       
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.val + " ");
           
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }


    void inOrderTraversal(Node root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    void postOrderTraversal(Node root) {
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    void levelOrderTraversal(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        System.out.print("Level Order Traversal: ");
        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.val + " ");
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
        System.out.println();
    }

    void insertINLevelOrder(Node root, int val) {
        if (root == null) {
            this.root = new Node(val);
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.left == null) {
                curr.left = new Node(val);
                return;
            } else {
                q.add(curr.left);
            }

            if (curr.right == null) {
                curr.right = new Node(val);
                return;
            } else {
                q.add(curr.right);
            }
        }
    }

    int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    int countLeafNodes(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }

    boolean searchNode(Node root, int val) {
        if (root == null) return false;
        if(root.val==val) return true;
        return searchNode(root.left, val) || searchNode(root.right, val);
    }

    int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    int maxVal(Node root){
        if(root==null) return 0;
        int leftMax=maxVal(root.left);
        int RightMax=maxVal(root.right);
        return Math.max(root.val,Math.max(leftMax,RightMax));
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);

        tree.insertINLevelOrder(tree.root, 2);
        tree.insertINLevelOrder(tree.root, 3);
        tree.insertINLevelOrder(tree.root, 4);
        tree.insertINLevelOrder(tree.root, 5);
        tree.insertINLevelOrder(tree.root, 6);
        tree.insertINLevelOrder(tree.root, 7);
        tree.insertINLevelOrder(tree.root, 8);
        tree.insertINLevelOrder(tree.root, 9);
        tree.insertINLevelOrder(tree.root, 10);

        tree.levelOrderTraversal(tree.root);

        System.out.print("Preorder Traversal: ");
        tree.preOrderTraversal(tree.root);
        System.out.println();

        System.out.print("Inorder Traversal: ");
        tree.inOrderTraversal(tree.root);
        System.out.println();

        System.out.print("Postorder Traversal: ");
        tree.postOrderTraversal(tree.root);
        System.out.println();

        System.out.println("Total Nodes: " + tree.countNodes(tree.root));
        System.out.println("Leaf Nodes: " + tree.countLeafNodes(tree.root));
        
        System.out.println("Search Node 5: " + tree.searchNode(tree.root, 5));
        System.out.println("Max " + tree.maxVal(tree.root));
    }
}
