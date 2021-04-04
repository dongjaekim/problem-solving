package April;

import java.util.Arrays;
import java.util.Comparator;

// find largest number of subset, at most m zeroes / n ones
public class lc_210403 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;

        int result = sol.findMaxForm(strs, m, n);
        System.out.println(result);
    }

    // dynamic programming
    public static class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            int[][] dp = new int[m+1][n+1];
            int output = 0;

            for(String s : strs) {
                int zeroCnt = 0;
                int oneCnt = 0;
                for(int i = 0; i < s.length(); i++) {
                    if(s.charAt(i) == '0')
                        zeroCnt++;
                    else
                        oneCnt++;
                }

                for(int i = m; i >= zeroCnt; i--) {
                    for(int j = n; j >= oneCnt; j--) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - zeroCnt][j - oneCnt] + 1);
                        System.out.println("dp["+i+"]["+j+"]: " + dp[i][j]);
                    }
                }
            }

            output = dp[m][n];
            return output;
        }
    }
}
