package problems.lv2;

import java.util.*;

class EmoticonDiscountEvent {
    int maxServiceCount;
    int maxPurchase;

    public int[] solution(int[][] users, int[] emoticons) {
        maxServiceCount = 0;
        maxPurchase = 0;

        findMaximumProfit(users, emoticons, new int[emoticons.length], 0);

        return new int[] {maxServiceCount, maxPurchase};
    }

    public void findMaximumProfit(int[][] users, int[] emoticons, int[] discountRate, int idx) {
        if (idx == discountRate.length) {
            int emoticonPurchase = 0;
            int emoticonServiceCount = 0;
            for (int i = 0; i < users.length; i++) {
                int totalPurchase = 0;
                for (int j = 0; j < emoticons.length; j++) {
                    if (users[i][0] <= discountRate[j])
                        totalPurchase += (int) emoticons[j] * (100 - discountRate[j]) / 100;
                }
                if (totalPurchase >= users[i][1])
                    emoticonServiceCount++;
                else
                    emoticonPurchase += totalPurchase;
            }

            if (maxServiceCount < emoticonServiceCount) {
                maxServiceCount = emoticonServiceCount;
                maxPurchase = emoticonPurchase;
            } else if (maxServiceCount == emoticonServiceCount)
                maxPurchase = Math.max(maxPurchase, emoticonPurchase);
        } else {
            for (int i = 10; i <= 40; i += 10) {
                discountRate[idx] = i;
                findMaximumProfit(users, emoticons, discountRate, idx + 1);
            }
        }
    }
}
