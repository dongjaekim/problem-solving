package problems.lv2;

import java.util.*;

class EmoticonDiscountEvent {
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        int[] discountRate = new int[emoticons.length];
        Arrays.fill(discountRate, 10);
        
        findMaximumProfit(users, emoticons, discountRate, 0, map);
        int max = 0;
        for (int key : map.keySet()) {
            max = Math.max(max, key);
        }   
        
        answer[0] = max;
        answer[1] = map.get(max);
        return answer;
    }
    
    public void findMaximumProfit(int[][] users, int[] emoticons, int[] discountRate, int idx, Map<Integer, Integer> map) {
        if (discountRate[idx] > 40)
            return;
        
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

        if (map.getOrDefault(emoticonServiceCount, 0) < emoticonPurchase)
            map.put(emoticonServiceCount, emoticonPurchase);
        
        for (int i = 0; i < discountRate.length; i++) {
            discountRate[i] += 10;
            findMaximumProfit(users, emoticons, discountRate, i, map);
            discountRate[i] -= 10;
        }
    }
}
