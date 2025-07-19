package DS.LinkedList;

public class CircularSinglyLinkedList {
    Node head;
    
    void display(Node head){
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        System.out.print("Head -> ");
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);

        System.out.println(current.data+"(back to head)");
    }
    
    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        System.out.print("Head -> ");
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);

        System.out.println(current.data+"(back to head)");
    }

    void insertBeg(int data){
        Node newNode=new Node(data);
        if(head==null) {
            newNode.next=newNode;
            head=newNode;
        }
        else{
            Node tp=head;
            while(tp.next!=head){
                tp=tp.next;
            }
            tp.next=newNode;
            newNode.next=head;
            head=newNode;
        }
    }

    void insertEnd(int data){
        Node newNode=new Node(data);
        if(head==null) {
            newNode.next=newNode;
            head=newNode;
        }
        else{
            Node tp=head;
            while(tp.next!=head){
                tp=tp.next;
            }
            tp.next=newNode;
            newNode.next=head;
        }
    }

    void insertPos(int data ,int pos){
        if(pos==1 && head==null) {
            insertBeg(data);
            return;
        }
        Node newNode=new Node(data);
        int i=0;
        Node tp=head;
        while(tp.next!=head && i<pos-2){
            i++;
            tp=tp.next;
        }
        newNode.next=tp.next;
        tp.next=newNode;
    }

    void splitCycle(){
        Node slow=head,fast=head;
        while(fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node head2=slow.next;
        slow.next=head;
        Node tp=head2;
        while(tp.next!=head){
            tp=tp.next;
        }

        tp.next=head2;
        System.out.print("first Loop : ");
        display(head);
        System.out.print("Second Loop : ");
        display(head2);
    }

    void deleteBeg(){
        if(head==null || head.next==head){
            throw new RuntimeException("Onnum Illa Maplaeii");
        }
        else{
            Node tp=head;
            while(tp.next!=head) tp=tp.next;
            head=head.next;
            tp.next=tp.next.next;
        }
    }

    void deleteEnd(){
        if(head==null||head.next==head) throw new RuntimeException("Onnum Illa Maplaeii");
        else {
            Node tp=head;
            while(tp.next.next!=head) tp=tp.next;
            tp.next=head;
        }
    }
    
    void deletePos(int pos){
        if(pos==0) throw new RuntimeException("thappana position thambi");
        else if (pos==1) deleteBeg();
        else{
            int i=0;
            Node tp=head;
            while(tp.next!=head && i<pos-2){
                tp=tp.next;
            }
            tp.next=tp.next.next;
        }

    }
    public static void main(String[] args) {
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();
        list.insertBeg(1);
        list.insertBeg(2);
        list.insertEnd(3);
        list.insertEnd(4);
        list.insertEnd(5);
        list.insertPos(10, 1);
        // list.display(list.head);
        // list.splitCycle();

        list.display();
        list.deletePos(2);
        list.display();
    }
}
