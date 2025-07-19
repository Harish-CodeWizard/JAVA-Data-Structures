package DS.Tree_DS;



public class BinarySearchTree {
    Node root;

    BinarySearchTree(int val) {
        root = new Node(val);
    }

// Insert a new value iteratively
    public void insertIter(int val) {
        if(root == null) {
            root = new Node(val);
            return;
        }
        Node curr = root;
        while(curr!=null){
            if (curr.val>val) {
                if(curr.left==null){
                    curr.left=new Node(val);
                    break;
                }
                curr = curr.left;
            }
            else {
                if(curr.right==null){
                    curr.right=new Node(val);
                    break;
                }
                curr = curr.right;
            }
        }
    }
    public void insertRecursive(int v){
        helper(root,v);
    }
        
    public Node helper(Node n,int v){
        if(n==null) return new Node(v);
        if(v>n.val) n.right=helper(n.right,v);
        else n.left=helper(n.left,v);
        return n;
    }

    public Node searchNode(Node root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (val < root.val) {
            return searchNode(root.left, val);
        }
        return searchNode(root.right, val);
    }

    public Node maxVal(Node root) {
        if (root == null) return null;
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public Node minVal(Node root) {
        if (root == null) return null;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    Node deleteNode(Node n,int val) {
        if(n==null) return null;
        if(val < n.val) n.left=deleteNode(n.left,val);
        else if(val > n.val) n.right=deleteNode(n.right,val);
        else{
            if(n.left==null && n.right==null) return null;
            else if(n.left==null) return n.right;
            else if(n.right==null) return n.left;
            Node temp=minVal(n.right);
            n.val=temp.val;
            n.right=deleteNode(n.right,temp.val);
        }
        return n;
    }

    void inorderTraversal(Node root) {
        if(root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }


    public static void main(String[] args) {
        // Example usage of BinarySearchTree
        BinarySearchTree bst = new BinarySearchTree(50);
        bst.insertIter(10);
        bst.insertIter(5);
        bst.insertIter(15);
        bst.insertIter(3);
        bst.insertIter(7);
        bst.insertIter(12);
        bst.insertIter(18);
        System.out.println("In-order traversal:");
        bst.inorderTraversal(bst.root);
        System.out.println("\nSearching for 7: " + (bst.searchNode(bst.root, 7) != null ? "Found" : "Not Found"));
        System.out.println("Searching for 20: " + (bst.searchNode(bst.root, 20) != null ? "Found" : "Not Found"));
        System.out.println("Max value: " + (bst.maxVal(bst.root) != null ? bst.maxVal(bst.root).val : "Tree is empty"));
        System.out.println("Min value: " + (bst.minVal(bst.root) != null ? bst.minVal(bst.root).val : "Tree is empty"));
        bst.deleteNode(bst.root, 10);
    }

}
