package DS.LinkedList;

// import javax.management.RuntimeErrorException;

class Node {
    int data;
    Node prev=null;
    Node next=null;
    Node(int data){
        this.data=data;
    }
}

public class DoublyLinkedList {
    Node head;
    void display(){
        Node tp=head;
        while(tp.next!=null){
            System.out.print(tp.data+" -> ");
            tp=tp.next;
        }
        System.out.println(tp.data+" -> NULL ");
        while(tp!=null){
            System.out.print(tp.data+" -> ");
            tp=tp.prev;
        }
        System.out.println("NULL ");

    }

    void insertBeg(int data){
        Node newNode=new Node(data);
        if(head==null) head=newNode;
        else{
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
        }
    }

    void insertEnd(int data){
        Node newNode=new Node(data);
        if(head==null) head=newNode;
        else{
            Node tp= head;
            while(tp.next!=null){
                tp=tp.next;
            }
                tp.next=newNode;
                newNode.prev=tp;
        }
    }

    void insertPos(int data,int pos){
        Node newNode = new Node(data);
        if(head==null && pos==1) {
            head=newNode;
            return;
        }
        Node tp=head;
        int i=1;
        while(tp.next!=null && i<pos-1){
            i++;
            tp=tp.next;
        }
        if(tp.next==null && i<pos-1){
            System.out.println("Position out of bounds");
            return;
        }
        newNode.next=tp.next;
        tp.next.prev=newNode;
        newNode.prev=tp;
        tp.next=newNode;
    }

    void deleteBeg(){
        if(head==null || head.next==null) {
            throw new RuntimeException("ooh you Made the list empty");
        }
        else{
            head=head.next;
            head.prev=null;
        }
    }

    void deleteEnd(){
        if(head==null || head.next==null){
            throw new RuntimeException("Hey you made the list Empty da Matti");
        }
        Node tp=head;
        while(tp.next.next!=null){
            tp=tp.next;
        }
        tp.next=null;
    }

    void deletePos(int pos){
        if(head==null || head.next==null){
            throw new RuntimeException("Hey you made the list Empty da Matti");
        }
        Node tp=head;
        int i=1;
         if (pos == 1) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
    }
        while(tp.next!=null && i<pos-1){
            i++;
            tp=tp.next;
        }

        tp.next=tp.next.next;
        tp.next.prev=tp;        
    }

    void insertSortedly(int data){
        // Node newNode =new Node(data);
        if(head==null || head.data>data){
            insertBeg(data);
            return;
        }


    }

    public static void main(String[] args) {
        DoublyLinkedList l1=new DoublyLinkedList();
        l1.insertBeg(1);
        l1.insertBeg(2);
        l1.insertBeg(3);
        l1.insertBeg(4);
        l1.insertEnd(5);
        l1.insertEnd(6);
        l1.insertPos(0, 3);
        l1.insertPos(15, 1);
        // l1.insertPos(7, 10); // Position out of bounds
        // l1.display();
        // l1.deleteBeg();
        // l1.deleteEnd();
        //l1.deletePos(1);
        l1.display();
        

    }
    
}
