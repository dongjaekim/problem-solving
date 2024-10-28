package problems.lv3;

import java.util.stream.Collectors;
import java.util.Arrays;

class IntegerTriangle {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0)
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                else if (j == triangle[i].length - 1)
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                else
                    dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
            }
        }
        
        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
            answer = Math.max(answer, dp[n - 1][i]);
        }
        
        return answer;
    }
}
