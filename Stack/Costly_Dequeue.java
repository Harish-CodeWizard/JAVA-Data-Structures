package DS.Stack;

import java.util.Stack;

public class Costly_Dequeue {
    Stack<Integer> stack1=new Stack<>();
    Stack<Integer> stack2=new Stack<>();

    void display(){
        if(stack1.isEmpty() && stack2.isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Elements in Queue: ");
        for(int i : stack1){
            System.out.print(i + " ");
        }
        for(int i : stack2){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public void enqueue(int x) {
        stack1.push(x);
    }
    void dequeue(){
        if(stack2.isEmpty()){
            if(stack1.isEmpty()){
                System.out.println("Queue is empty");
                return;
            }
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        System.out.println("Dequeued element: " + stack2.pop());

    }

    public static void main(String[] args) {
        Costly_Dequeue queue = new Costly_Dequeue();
        queue.enqueue(1);   
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.display();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(6);
        queue.enqueue(7);
    }
}
