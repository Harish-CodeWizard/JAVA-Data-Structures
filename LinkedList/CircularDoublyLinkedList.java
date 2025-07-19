package DS.LinkedList;

class CircularDoublyLinkedList {
    Node head;
    void display(){
        Node tp = head;
        Node tail = head.prev;
        if (tp == null) {
            System.out.println("List is empty");
            return;
        }
        do {
            System.out.print(tp.data + " <-> ");
            tp = tp.next;
        } while (tp != head);
        System.out.print(tp.data);
        System.out.println("(head)");
        tp=tail;
        do {
            System.out.print(tp.data + " <-> ");
            tp = tp.prev;
        } while (tp != tail);
        System.out.print(tp.data);
        System.out.println("(tail)");
    }

    void insertBeg(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
            newNode.next=newNode;
            newNode.prev=newNode;
        }
        else{
            Node tail=head.prev;
            tail.next=newNode;
            newNode.prev=tail;
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
        }
    }

    void insertEnd(int data){
           Node newNode = new Node(data);
        if(head==null){
            head=newNode;
            newNode.next=newNode;
            newNode.prev=newNode;
        }
        else{
            Node tail=head.prev;
            tail.next=newNode;
            newNode.prev=tail;
            newNode.next=head;
            head.prev=newNode;
            tail=newNode; //ni itha(intha oru line) panla nalum work aagum ,aana tail nu oru node fix panra avlothan.  
        }
    }
    
    void insertPos(int data , int pos){
        Node tail = head.prev;
        Node newNode = new Node(data);
        if(head==null && pos==1){
            insertBeg(data);
        }
        Node tp=head;
        while (tp!=tail) {
            
        }
    }
    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        list.insertBeg(40);
        list.insertBeg(30);
        list.insertBeg(20);
        list.insertBeg(10);
        // list.display();
        list.insertEnd(50);
        list.insertEnd(60);
        list.insertEnd(70);
        list.display();
    }
}
