package March;

public class lc_210328 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        bestSolution best_sol = new bestSolution();

        int result = sol.countSubstrings("xabax");
        System.out.println(result);

        int best_result = best_sol.countSubstrings("xabax");
        System.out.println(best_result);
    }

    public static class Solution {
        public int countSubstrings(String s) {
            int output = 0;
            int[][] check = new int[s.length()][s.length()];

            for(int i = s.length() - 1; i >= 0; i--) {
                for(int j = i; j < s.length(); j++) {
                    if(i == j)
                        check[i][j] = 1;

                    if(check[i][j] == 0) {
                        String str = s.substring(i, j+1);
                        boolean flag = true;
                        for(int k = 0; k < str.length() / 2; k++) {
                            if(str.charAt(k) != str.charAt(str.length() - k - 1)) {
                                flag = false;
                                break;
                            }
                        }
                        if(flag)
                            check[i][j] = 1;
                        else
                            continue;
                    }

                    if(i > 0 && j < s.length() - 1) {
                        if(s.charAt(i - 1) == s.charAt(j + 1))
                            check[i - 1][j + 1] = 1;
                    }
                    output++;
                }
            }

            return output;
        }
    }

    public static class bestSolution {
        public int countSubstrings(String s) {
            int output = 0;

            if(s == null || s.length() == 0)
                return 0;

            for(int i = 0; i < s.length(); i++) {
                output += countPalindromes(s, i, i);
                output += countPalindromes(s, i, i+1);
            }

            return output;
        }

        public int countPalindromes(String s, int l, int r) {
            int cnt = 0;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                cnt++;
                l--;
                r++;
            }

            return cnt;
        }
    }
}
