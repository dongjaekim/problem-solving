import java.util.*;

class CorrectBracket {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (stack.isEmpty())
                stack.push(c);
            else if (c == ')' && stack.peek() == '(')
                stack.pop();
            else
                stack.push(c);
        }
        
        return stack.isEmpty();
    }
}
