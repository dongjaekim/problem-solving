package April;

import java.util.Locale;

public class lc_210407 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        boolean result = sol.halvesAreAlike("book");
        System.out.println(result);
    }

    public static class Solution {
        public boolean halvesAreAlike(String s) {
            int cnt = 0;
            int len = s.length();
            s = s.toLowerCase();

            for(int i = 0; i < len / 2; i++) {
                if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i'
                || s.charAt(i) == 'o' || s.charAt(i) == 'u')
                    cnt++;
                if(s.charAt(len - i - 1) == 'a' || s.charAt(len - i - 1) == 'e' || s.charAt(len - i - 1) == 'i'
                        || s.charAt(len - i - 1) == 'o' || s.charAt(len - i - 1) == 'u')
                    cnt--;
            }

            return cnt == 0;
        }
    }

    public static class bestSolution {
        public boolean halvesAreAlike(String s) {
            s = s.toLowerCase();
            int cnt = 0;
            int halfLen = s.length() / 2;

            for(int i = 0; i < halfLen; i++) {
                if(isVowel(s.charAt(i)))
                    cnt++;
                if(isVowel(s.charAt(i + halfLen)))
                    cnt--;
            }

            return cnt == 0;
        }

        public boolean isVowel(char c) {
            switch(c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    return true;
                default:
                    return false;
            }
        }
    }
}
