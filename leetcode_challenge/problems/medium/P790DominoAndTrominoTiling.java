package problems.medium;

import java.util.Arrays;

public class P790DominoAndTrominoTiling {

    public static int numTilings2(int n) {
        final int MOD = (int) Math.pow(10, 9) + 7;

        if (n < 3)
            return n;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 3]) % MOD;
        }
        return dp[n];
    }

    public static int numTilings(int n) {
        // dp
        long[][] dp = new long[n + 1][3];
        final int MOD = (int) Math.pow(10, 9) + 7;

        if (n < 3)
            return n;

        dp[0][0] = 1;
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 2][0] + dp[i - 2][1] + dp[i - 2][2]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }

        return (int) dp[n][0];
    }

    public static void main(String[] args) {
        int p1 = numTilings(3);
        System.out.println("p1 = " + p1);

        int p2 = numTilings(1);
        System.out.println("p2 = " + p2);

        int p3 = numTilings(4);
        System.out.println("p3 = " + p3);

        int p4 = numTilings(30);
        System.out.println("p4 = " + p4);
    }
}
