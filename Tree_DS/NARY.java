package DS.Tree_DS;

import java.util.*;

// class Node{
//     int data;
//     List<Node> child;
//     Node(int val){
//         data=val;
//         child=new ArrayList<>();
//     }
// }

class NARY {
    Node root=null;
    NARY(int val){
        root=new Node(val);
    }
    public void insert(Node node,int val){
        Node new_node= new Node(val);
        node.child.add(new_node);
    }

    public void preOrder(Node node){
        if(node==null) return;
        System.out.print(node.data+" ");
        for(Node x:node.child) preOrder(x);
    }

    public void postOrder(Node node){
        if(node==null) return;
        for(Node x:node.child) preOrder(x);
        System.out.print(node.data+" ");
    }

    void levelOrderTraversal(Node root){
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");
            for (Node child : current.child) {
                queue.add(child);
            }
        }
    }

    int height(Node root){
        int max=0;
        if(root==null) return 0;
        for(Node c:root.child){
            max= Math.max(height(c),max);
        }
        return max+1;
    }
    
    int countNodes(Node root){
        if(root==null) return 0;
        int count = 1;
        for(Node x:root.child){
            count+=countNodes(x);
        }
        return count;
    }
    
    int countLeaf(Node root){
        if(root==null) return 0;
        if(root.child.isEmpty()) return 1;
        int l=0;
        for(Node x:root.child){
            l+=countLeaf(x);
        }
        return l;
    }

    public static void main(String[] args) {
    NARY tree = new NARY(1);
    Node root = tree.root;

    tree.insert(root, 2);
    tree.insert(root, 3);
    tree.insert(root, 4);
    tree.insert(root, 5);

    // Children of 3
    tree.insert(root.child.get(1), 6);
    tree.insert(root.child.get(1), 7);

    // Children of 2
    tree.insert(root.child.get(0), 8);
    tree.insert(root.child.get(0), 9);

    // Children of 4
    tree.insert(root.child.get(2), 10);

    // Children of 6
    tree.insert(root.child.get(1).child.get(0), 11);
    tree.insert(root.child.get(1).child.get(0), 12);

    // Children of 7
    tree.insert(root.child.get(1).child.get(1), 13);

    // Another child of root
    tree.insert(root, 14);
    tree.insert(root, 14);

    tree.postOrder(tree.root);
    System.out.println();
    tree.levelOrderTraversal(tree.root);
    System.out.println();
    System.out.println(tree.height(root));
    System.out.println(tree.countLeaf(root));
    }
}

