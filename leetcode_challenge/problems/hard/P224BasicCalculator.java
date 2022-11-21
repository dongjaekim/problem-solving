package problems.hard;

import java.util.Stack;

public class P224BasicCalculator {
    public static int calculate(String s) {
        int output = 0;
        int num = 0;
        int sign = 1;
        // 2-(1-2)

        Stack<Integer> stack = new Stack<>();
        stack.push(sign);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num * 10 + (s.charAt(i) - '0');
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                output += num * sign;
                sign = stack.peek() * (s.charAt(i) == '+' ? 1 : -1);
                num = 0;
            } else if (s.charAt(i) == '(') {
                stack.push(sign);
            } else if (s.charAt(i) == ')') {
                stack.pop();
            }
        }
        output += sign * num;

        return output;
    }

    public static void main(String[] args) {
        int p1 = calculate("1 + 1");
        System.out.println("p1 = " + p1);

        int p2 = calculate(" 2-1 + 2 ");
        System.out.println("p2 = " + p2);

        int p3 = calculate("(1+(4+5+2)-3)+(6+8)");
        System.out.println("p3 = " + p3);
    }
}
