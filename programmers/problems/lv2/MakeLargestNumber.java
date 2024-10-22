import java.util.*;

class MakeLargestNumber {
    public String solution(String number, int k) {
        int targetLength = number.length() - k;
        StringBuilder sb = new StringBuilder();
        
        while (targetLength > 0) {
            for (int i = 9; i >= 0; i--) {
                int idx = number.indexOf(String.valueOf(i));
                if (idx >= 0 && number.length() - idx >= targetLength) {
                    targetLength--;
                    sb.append(i);
                    number = number.substring(idx + 1);
                    break;
                }
            }
        }
        
        return sb.toString();
    }
  
    public String bestSolution(String number, int k) {
        char[] answer = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && c > stack.peek() && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = stack.get(i);
        }
        
        return new String(answer);
    }
}
