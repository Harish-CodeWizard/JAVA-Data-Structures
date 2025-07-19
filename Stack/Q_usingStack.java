package DS.Stack;

import java.util.Stack;

public class Q_usingStack {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    void display() {
        if (stack1.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        for (int i = stack1.size()-1 ; i >=0; i--) {
            System.out.print(stack1.get(i) + " ");
        }
        System.out.println();
    }

    public void enqueue(int val) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(val);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    int dequeue(){
        return stack1.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        Q_usingStack queue = new Q_usingStack();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();
        System.out.println(queue.dequeue()); // 10
        System.out.println(queue.dequeue()); // 20
        System.out.println(queue.dequeue()); // 30
        queue.display();
    }
}