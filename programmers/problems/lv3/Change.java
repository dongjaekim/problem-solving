package problems.lv3;

import java.util.*;

class Change {
    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];

        Arrays.sort(money);
        for (int i = 0; i <= n; i++) {
            if (i % money[0] == 0)
                dp[i] = 1;
        }

        for (int i = 1; i < money.length; i++) {
            for (int j = money[i]; j <= n; j++) {
                dp[j] += dp[j - money[i]];
            }
        }

        return dp[n] % 1000000007;
    }
}
