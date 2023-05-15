package problems.medium;

public class P1035UncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                dp[i][j] = nums1[i - 1] == nums2[j - 1] ? dp[i - 1][j - 1] + 1
                        : Math.max(dp[i - 1][j], dp[i][j - 1]);

        System.out.println("ArrayUtils.Array2DToString(dp) = \n" + ArrayUtils.Array2DToString(dp));
        
        return dp[m][n];
    }

    public static void main(String[] args) {
        int e1 = maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}); // 2
        int e2 = maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}); // 3
        int e3 = maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}); // 2

        System.out.println("e1 = " + e1);
        System.out.println("e2 = " + e2);
        System.out.println("e3 = " + e3);
    }
}
