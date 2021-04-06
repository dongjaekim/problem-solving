package April;

import java.util.ArrayList;
import java.util.Arrays;

public class lc_210405_2 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int result = sol.longestValidParentheses(")()())");
        System.out.println(result);
    }

    public static class Solution {
        public int longestValidParentheses(String s) {
            int max = 0, cnt = -1;
            char[] stack = new char[s.length()];

            if(stack.length == 0)
                return 0;
            Arrays.fill(stack, '0');
            stack[0] = s.charAt(0);

            for(int i = 1; i < s.length(); i++) {
                if(s.charAt(i) == '(')
                    stack[i] = s.charAt(i);
                else {
                    int j = i-1;
                    while(stack[j] == '0' && j > 0)
                        j--;
                    if(stack[j] == '(')
                        stack[j] = '0';
                    else
                        stack[i] = s.charAt(i);
                }
            }

            for(int i = 0; i < stack.length; i++) {
                if(stack[i] != '0') {
                    if(cnt == -1)
                        max = i;
                    else
                        max = Math.max(max, i - cnt - 1);
                    cnt = i;
                }
            }

            return cnt == -1 ? s.length() : Math.max(max, s.length() - cnt - 1);
        }
    }
}
