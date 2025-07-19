package DS.LinkedList;

// class Node{
//     int data;
//     Node next;
//     Node(int data){
//         this.data=data;
//     }
// }

class LinkedList{
    Node head;
    void display(){
        Node tp=head;
        while(tp!=null){
            System.out.print(tp.data+"->");
            tp=tp.next;
        }
        System.out.println("NULL");
    }
    void insertBeg(int data){
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;
    }
    void insertEnd(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node tp=head;
        while(tp.next!=null){
            tp=tp.next;
        }
        tp.next=newNode;
    }
    void insertPos(int data,int pos){
        if(pos==0) {
            insertBeg(data);
            return;
        }
        Node newNode=new Node(data);
        Node tp=head;
        int ind=0;
        while(tp.next!=null && ind!=pos){
            ind++;
            tp=tp.next;
        }
        if(tp.next==null && ind!=pos){
            System.out.println("Position out of bounds");
            return;
        }
        newNode.next=tp.next;
        tp.next=newNode;
    }
    void deleteBeg(){
        if(head==null){
            System.out.println("Empty");
            return;
        }
        head=head.next;
    }
    void deleteEnd(){
        if(head==null){
            System.out.println("Empty");
            return;
        }
        if(head.next==null){
            head=null;
            return;
        }
        Node tp=head;
        while(tp.next.next!=null){
            tp=tp.next;
        }
        tp.next=null;
    }
    void deletePos(int pos){
        if(head==null){
            System.out.println("Empty");
            return;
        }
        if(pos==0) {
            deleteBeg();
            return;
        }
        Node tp=head;
        int ind=0;
        while(tp.next!=null && ind!=pos-1){
            ind++;
            tp=tp.next;
        }
        if(tp.next==null || ind!=pos-1){
            System.out.println("Position out of bounds");
            return;
        }
        tp.next=tp.next.next;
    }
        
    int search(int num){
        Node tp=head;
        int ind=0;
        while(tp!=null){
            if(tp.data==num) return ind+1; // return 1-based index
            ind++;
            tp=tp.next;
        }
        return -1;
    }
    
    boolean seaarchAndModify(int num){
        Node prev=head;
        Node curr=prev.next;
        if(prev.data==num) return true;
        while(curr!=null) {
            if(curr.data==num) {
                prev.next=curr.next;
                curr.next=head;
                head=curr;
                return true;
            }
            prev=curr;
            curr=curr.next;
        }
        return false;
    }
    String isSorted(){
        Node tp=head;
        boolean asc=true;
        boolean desc=true;
        while(tp.next!=null){
            if(tp.data>tp.next.data) asc=false;
            if(tp.data<tp.next.data) desc=false;
            tp=tp.next;
        }
        return (asc || desc)? "Sorted":"Mixed";
    }

    void removeDup(){
        Node tp=head;
        while(tp.next!=null){
            if(tp.data==tp.next.data) tp.next=tp.next.next;
            else tp=tp.next;
        }
    }
    boolean formsCycle(){
        Node slow=head;
        Node fast=head;
        while(slow.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }
    void formCycle(){
        Node tp=head;
        while(tp.next!=null){
            tp=tp.next;
        }
        tp.next=head.next.next;
     }

    void reverse() {
        Node curr = head, prev = null, next = null;
        while (curr != null) {
            next = curr.next;     // save next node
            curr.next = prev;     // reverse link
            prev = curr;          // move prev forward
            curr = next;          // move curr forward
        }
        head=prev; // new head
    }

    void insertSortedly(int data){
        
    }


    public static void main(String[] args) {
        LinkedList l1=new LinkedList();
        l1.insertBeg(20);
        l1.insertBeg(10);
        l1.insertEnd(30);
        l1.insertEnd(40);
        l1.insertPos(5, 0);
        l1.insertPos(15, 2);
        
        l1.display();
        // System.out.println("\nFound at:"+l1.search(15));
        // System.out.println("Found at:"+l1.search(5));
        // System.out.println("Found at:"+l1.search(6));
        // System.out.println((l1.seaarchAndModify(40)));
        // l1.display();
        // System.out.println(l1.isSorted());
        // l1.removeDup();
        // l1.display();
        // System.out.println(l1.formsCycle());
        // l1.formCycle();
        // l1.display();
        // System.out.println(l1.formsCycle());
        // l1.deleteBeg();
        l1.reverse();
        l1.display();


    }
}