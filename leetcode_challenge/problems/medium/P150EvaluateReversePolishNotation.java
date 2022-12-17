package problems.medium;

import java.util.Stack;

public class P150EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "-":
                case "/":
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    int calc = "-".equals(tokens[i]) ? num2 - num1 : num2 / num1;
                    stack.push(calc);
                    break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        int p1 = evalRPN(new String[]{"2", "1", "+", "3", "*"});
        System.out.println("p1 = " + p1);

        int p2 = evalRPN(new String[]{"4", "13", "5", "/", "+"});
        System.out.println("p2 = " + p2);

        int p3 = evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
        System.out.println("p3 = " + p3);
    }
}
