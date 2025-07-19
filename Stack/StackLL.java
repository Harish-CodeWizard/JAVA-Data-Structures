package DS.Stack;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
    }
}

public class StackLL {
    Node top;
    public void display(){
        if(top==null){
            System.out.println("Null");
            return;
        }
        Node tp=top;
        while(tp!=null){
            System.out.print(tp.data+" ");
            tp=tp.next;
        }
        System.out.println();
   }

    void push(int data){
        Node newNode =new Node(data);
        
    }

    public static void main(String[] args) {
        
        StackLL stack = new StackLL();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped element: " + stack.pop());
        stack.display();
    }
}
