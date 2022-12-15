package problems.medium;

public class P1143LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = (text1.charAt(i - 1) == text2.charAt(j - 1)) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[text1.length()][text2.length()];
    }

    public int best_longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // If text1 doesn't reference the shortest string, swap them.
        if (n < m) {
            String temp = text1;
            text1 = text2;
            text2 = temp;

            m = text1.length();
            n = text2.length();
        }

        // The previous and current column starts with all 0's and like
        // before is 1 more than the length of the first word.
        int[] previous = new int[m + 1];
        int[] current = new int[m + 1];

        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                // If the corresponding characters for this cell are the same...
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    current[i] = 1 + previous[i - 1];
                    // Otherwise they must be different...
                } else {
                    current[i] = Math.max(previous[i], current[i - 1]);
                }
            }

            // The current column becomes the previous one, and vice versa.
            int[] temp = previous;
            previous = current;
            current = temp;
        }

        // The original problem's answer is in previous[0]. Return it.
        return previous[m];
    }

    public static void main(String[] args) {
        int p1 = longestCommonSubsequence("abcde", "ace");
        System.out.println("p1 = " + p1);

        int p2 = longestCommonSubsequence("abc", "abc");
        System.out.println("p2 = " + p2);

        int p3 = longestCommonSubsequence("psnw", "vozsh");
        System.out.println("p3 = " + p3);

        int p4 = longestCommonSubsequence("oxcpqrsvwf", "shmtulqrypy");
        System.out.println("p4 = " + p4);

        int p5 = longestCommonSubsequence("bsbininm", "jmjkbkjkv");
        System.out.println("p5 = " + p5);
    }
}
