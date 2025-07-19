package DS.Stack;

class Stack {
    int top = -1;       // stack is initially empty
    int size;           // maximum size of stack
    int[] stack;        // array to store stack elements

    // Constructor
    Stack(int size) {
        this.size = size;
        stack = new int[size];
    }

    void display(){
        if(!isEmpty()){
            for(int i=0;i<=top;i++){
                System.out.print(stack[i]+" ");
            }
            System.err.println();
        }
        else throw new StackOverflowError("Underflow");
    }

    boolean isFull() {
        return top == size - 1;  // stack is full if top is at the last index
    }
    boolean isEmpty() {
        return top == -1;  // stack is empty if top is at -1
    }

    void push(int data){
        if(isFull()) {
            System.out.println("Stack overFlow");
            return ;
        }
        stack[++top]=data;
    }
    int pop(){
        if(isEmpty()) {
            System.out.println("stack underflow");
            return -1;
        }
        return stack[top--];
    }
    int peek(){
        return stack[top];
    }


    public static void main(String[] args) {
        Stack s = new Stack(3);
        s.push(10);
        s.push(20);
        s.push(30);
        s.display();
        System.out.println("Top element: " + s.peek());
        System.out.println("Popped element: " + s.pop());
        s.display();
    }
}
