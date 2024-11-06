package problems.lv4;

class NumberOfBrackets {
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
      //  dp[3] = dp[2] * dp[0] + dp[1] * dp[1]
        
        for(int i = 2; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i] += dp[i - j - 1] * dp[j];
            }
        }
        
        return dp[n];
    }
}
