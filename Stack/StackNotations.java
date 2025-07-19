package DS.Stack;

import java.util.Stack;


public class StackNotations {
    static int postRes(String s){
        Stack <Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                stack.push(ch-'0');
            } 
            else {
                char operation = ch;
                int b = stack.pop();
                int a = stack.pop();
                switch (operation) {
                    case '+':
                    stack.push(a + b);
                    break;
                    case '-':
                    stack.push(a - b);
                    break;
                    case '*':
                    stack.push(a * b);
                    break;
                    case '/':
                    stack.push(a / b);
                    break;
                    case '%':
                    stack.push(a % b);
                    break;
                    case '^':
                    stack.push((int) Math.pow(a, b));
                    break;
                }   
            }
        }
        return stack.pop();
    }
    static int precedence(char ch) {
        switch (ch) {
            case '+': case '-': return 1;
            case '*': case '/': case '%': return 2;
            case '^': return 3;
        }
        return -1;
    }

    static String toPostFix(String s) {
        Stack<Character> operator = new Stack<>();
        Stack<String> operand = new Stack<>();
        for(char ch:s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                operand.push(String.valueOf(ch));
            }
            else if(ch=='('){
                operator.push('(');
            }
            else if(ch==')'){
                while(!operator.isEmpty() && operator.peek()!='('){
                    String op2 = operand.pop();
                    String op1 = operand.pop();
                    char op = operator.pop();
                    operand.push(op1 + op2 + op);
                }
                operator.pop();
            }
            else { // operator
                while (!operator.isEmpty() && precedence(ch) <= precedence(operator.peek())) {
                    String op2 = operand.pop();
                    String op1 = operand.pop();
                    char op = operator.pop();
                    operand.push(op1 + op2 + op);
                }
                operator.push(ch);
            }
        }

        while (!operator.isEmpty()) {
            String op2 = operand.pop();
            String op1 = operand.pop();
            char op = operator.pop();
            operand.push(op1 + op2 + op);
        }

        return operand.pop();
    }
    
    // for prefix notation, we can reverse the string and use the same logic;
    // remember to reverse the order of operands in the switch case. else change the variable a,b such that 
    // a is the first operand and b is the second operand.
    public static void main(String[] args) {
        String postfix="24+4*6-";
        // System.out.println(postRes(postfix));
        String infix="((2+4)*6)-4";
        System.out.println(toPostFix(infix)); 
        System.out.println(postRes(toPostFix(infix))); 
    }
}
