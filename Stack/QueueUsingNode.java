package DS.Stack;

public class QueueUsingNode {
    Node front,rear;

    void display(){
        if(front==null) return;
        while(front!=null){
            System.out.print(front.data  +"->");
        }
        System.out.println();
    }
    void enqueue(int val){
        Node newNode=new Node(val);
        if(front == null) {
            rear=newNode;
            front=newNode;
            return;
        }
        rear.next=newNode;
        rear=newNode;
    }

    void dequeue(int val){
        front=front.next;
    }


    public static void main(String[] args) {
        QueueUsingNode q1=new QueueUsingNode();
        q1.enqueue(0);
        q1.enqueue(1);
        q1.enqueue(2);
        q1.display();

    }
}
