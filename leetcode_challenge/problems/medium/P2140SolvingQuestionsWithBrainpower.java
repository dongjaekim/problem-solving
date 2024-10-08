package problems.medium;

import util.ArrayUtils;

public class P2140SolvingQuestionsWithBrainpower {
    public static long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int point = questions[i][0];
            int brainpower = questions[i][1];
            int index = Math.min(i + brainpower + 1, n);

            dp[i] = Math.max(point + dp[index], dp[i + 1]);
        }

        return dp[0];
    }

    public static long mostPoints2(int[][] questions) {
        int n = questions.length;
        int[] dp = new int[n + 1];

        int max = 0;

        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i] + questions[i - 1][0];

            if (max < dp[i])
                max = dp[i];

            int next = questions[i - 1][1] + i;
            if (next < n) {
                for (int j = next + 1; j < dp.length; j++)
                    dp[j] = Math.max(dp[j], dp[i]);
            }
            System.out.println("step " + i + " = " + ArrayUtils.Array1DToString(dp));
        }
        System.out.println("max = " + max);
        return Math.max(dp[n], max);
    }

    public static void main(String[] args) {
        long e1 = mostPoints(new int[][]{{3, 2}, {4, 3}, {4, 4}, {2, 5}}); // 5
        long e2 = mostPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}}); // 7
        long e3 = mostPoints(new int[][]{{12, 46}, {78, 19}, {63, 15}, {79, 62}, {13, 10}}); // 79
        long e4 = mostPoints(new int[][]{{21, 5}, {92, 3}, {74, 2}, {39, 4}, {58, 2}, {5, 5}, {49, 4}, {65, 3}}); // 157
        long e5 = mostPoints(new int[][]{{72,5},{36,5},{95,5},{50,1},{62,1},{14,3},{72,5},{86,2},{43,3},{51,3},{14,1},{91,5},{47,4},{72,4},{63,5},{40,3},{68,1},{8,3},{84,5},{7,5},{40,1},{35,3},{66,2},{39,5},{40,1},{92,3},{67,5},{34,3},{84,4},{75,5},{6,1},{71,3},{77,3},{25,3},{53,3},{32,3},{88,5},{18,2},{21,3},{78,2},{69,5},{45,4},{94,2},{70,1},{85,2},{7,2},{68,4},{71,4},{57,2},{12,5},{53,5},{51,3},{46,1},{28,3}}); // 845

        System.out.println("e1 = " + e1);
        System.out.println("e2 = " + e2);
        System.out.println("e3 = " + e3);
        System.out.println("e4 = " + e4);
        System.out.println("e5 = " + e5);
    }
}
