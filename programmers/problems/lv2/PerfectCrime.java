package problems.lv2;

import java.util.Arrays;

public class PerfectCrime {
    int min = 120;

    public static void main(String[] args) {
        PerfectCrime perfectCrime = new PerfectCrime();
        int e1 = perfectCrime.solution(new int[][] { { 1, 2 }, { 2, 3 }, { 2, 1 } }, 4, 4);
        System.out.println("e1 = " + e1);
    }

    public int solution(int[][] info, int n, int m) {
        return dp(info, n, m);
    }

    public void dfs(int[][] info, int n, int m, int idx, int aTotal, int bTotal) {
        if (aTotal >= n || bTotal >= m)
            return;
        else if (idx == info.length) {
            min = Math.min(min, aTotal);
            return;
        }

        dfs(info, n, m, idx + 1, aTotal + info[idx][0], bTotal);
        dfs(info, n, m, idx + 1, aTotal, bTotal + info[idx][1]);
    }

    public int dp(int[][] info, int n, int m) {
        int[][] dp = new int[info.length + 1][m];
        for (int i = 1; i < dp.length; i++) {
            Arrays.fill(dp[i], n);
        }

        for (int i = 1; i < dp.length; i++) {
            int a = info[i - 1][0];
            int b = info[i - 1][1];
            for (int j = 0; j < m; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + a);

                if (j + b < m) {
                    dp[i][j + b] = Math.min(dp[i][j + b], dp[i - 1][j]);
                }
            }
        }

        int min = n;
        for (int i = 0; i < m; i++) {
            min = Math.min(min, dp[info.length][i]);
        }

        return min >= n ? -1 : min;
    }
}
