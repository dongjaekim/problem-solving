package problems.hard;

import java.util.Arrays;

public class P1478AllocateMailboxes {
    public static int minDistance(int[] houses, int k) {
        if (houses.length == k)
            return 0;

        Arrays.sort(houses);

        int[][] distance = new int[houses.length][houses.length];
        for (int i = 0; i < houses.length; i++) {
            for (int j = 0; j < houses.length; j++) {
                int mid = houses[(i + j) / 2];
                for (int n = i; n <= j; n++)
                    distance[i][j] += Math.abs(mid - houses[n]);
            }
        }

        int[][] dp = new int[k + 1][houses.length + 1];

        for (int i = 0; i < houses.length; i++)
            dp[1][i + 1] = distance[0][i];

        for (int i = 2; i <= k; i++) {
            for (int j = 0; j < houses.length; j++) {
                for (int n = j; n >= i - 1; n--) {
                    if (dp[i][j + 1] == 0)
                        dp[i][j + 1] = dp[i - 1][n] + distance[n][j];
                    else
                        dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i - 1][n] + distance[n][j]);
                }
            }
        }
        
        return dp[k][houses.length];
    }

    public static void main(String[] args) {
        int p1 = minDistance(new int[]{1, 4, 8, 10, 20}, 3);
        System.out.println("p1 = " + p1);

        int p2 = minDistance(new int[]{2, 3, 5, 12, 18}, 2);
        System.out.println("p2 = " + p2);
    }
}
