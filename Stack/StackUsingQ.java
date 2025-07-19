package DS.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQ {
    Queue<Integer> q = new LinkedList<>();

    void push(int x){
        q.add(x);
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.remove());// Remove the front element and add it to the back
        }
    }
    void pop(){
        q.remove();        
    }
    void peek(){
        System.out.println("Top element: " + q.peek());
    }

    boolean isEmpty(){
        return q.isEmpty();
    }
    void display(){
        if(q.isEmpty()){
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Elements in Stack: ");
        for(int i : q){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackUsingQ stack = new StackUsingQ();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        stack.peek(); // Should print 30
        stack.pop(); // Should remove 30
        stack.display(); // Should display 10 20
        stack.peek(); // Should print 20
        stack.pop(); // Should remove 20
        stack.display(); // Should display 10
    }
}
