package DS.Stack;


public class queue {
    int[] arr;
    int front, rear,size;

    queue(int size) {
        arr = new int[size];
        this.front = -1;
        this.rear = -1;
        this.size = size;
    }

    public boolean isEmpty() {
        return front == -1;
    }
    public boolean isFull() {
        return (rear+1)% size == front;
    }

    void enqueue(int val){
        if(isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if (isEmpty()) {
            front = 0;
            // rear = 0;
        }
        rear = (rear + 1) % size;
        arr[rear] = val;
    }

    void dequeue(){
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Dequeued element: " + arr[front]);
        if (front == rear) {
            // kadaisi element ku
            front = -1;
            rear = -1;
        }
        else front = (front + 1) % size;
        //System.out.println("Dequeued element: " + arr[(front++)%size]);

    }

    void display(){
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        // System.out.print(front + " to " + rear + ": ");
        for(int i = front; i <= rear; i++) {
            System.out.print(arr[i%size] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        queue q1=new queue(4);
        q1.enqueue(10);
        q1.enqueue(20);
        q1.enqueue(30);
        q1.enqueue(35);
        q1.display();
        q1.dequeue();
        q1.display();
        q1.enqueue(40);
        q1.display();
        q1.dequeue();
        q1.enqueue(50);
        q1.display();
        q1.enqueue(60);
        q1.display();
        q1.display();
        q1.dequeue();
        q1.dequeue();
        q1.dequeue();
        q1.dequeue();
        q1.dequeue();
        q1.dequeue();
        q1.display();
        q1.enqueue(20);
        q1.display();
    }
}
