package March;

public class lc_210328 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int result = sol.countSubstrings("aaaaa");
        System.out.println(result);
    }

    public static class Solution {
        public int countSubstrings(String s) {
            int output = 0;
            boolean check = true;

            for(int i = 0; i < s.length(); i++)
                output += checkPalindrome(i, s.substring(i, i+1), s);

            for(int i = 0; i < s.length() / 2; i++) {
                if(s.charAt(i) != s.charAt(s.length() - i - 1)) {
                    check = false;
                    break;
                }
            }

            if(check)
                output++;
            // aaaaa - a a a a a
            // aa aa aa aa
            // aaa aaa aaa
            // aaaa aaaa
            // aaaaa
            return output;
        }

        public int checkPalindrome(int start, String substr, String s) {
            int output = 0;
            boolean check = true;

            if(substr.equals(s))
                return output;

            System.out.println("start: " + start + " // substr: " + substr);
            for(int i = 0; i < substr.length() / 2; i++) {
                if(substr.charAt(i) != substr.charAt(substr.length() - i - 1)) {
                    check = false;
                    break;
                }
            }

            if(check) {
                output++;

                if(start + substr.length() >= s.length())
                    return output;

                output += checkPalindrome(start, s.substring(start, start + substr.length() + 1), s);
                if(start != 0 && substr.length() != s.length())
                    output += checkPalindrome(start, s.substring(start - 1, start + substr.length() + 1), s);
            }

            return output;
        }

    }
}
