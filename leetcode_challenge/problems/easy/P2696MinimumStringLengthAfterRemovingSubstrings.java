package problems.easy;

import java.util.Stack;

public class P2696MinimumStringLengthAfterRemovingSubstrings {
    public static void main(String[] args) {
        int e1 = minLength("ABFCACDB");
        int e2 = minLength("ACBBD");
        int e3 = minLength("CCCCDDDD");

        System.out.println("e1 = " + e1);
        System.out.println("e2 = " + e2);
        System.out.println("e3 = " + e3);
    }

    public static int minLength(String s) {
        Stack<Character> stack = new Stack<>();

        char prev = '0';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((prev == 'A' && c == 'B') || (prev == 'C' && c == 'D')) {
                stack.pop();
                if (stack.empty())
                    prev = '0';
                else
                    prev = stack.peek();
            } else {
                stack.push(c);
                prev = c;
            }
        }

        return stack.size();
    }
}
