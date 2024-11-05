package problems.lv2;

class DeliveryAndPickups {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int dIdx = n;
        int pIdx = n;
        
        while (pIdx + dIdx > 0) {
            int currentCap = cap;
            int maxDIdx = 0;
            for (int i = dIdx; i >= 1; i--) {
                if (deliveries[i - 1] > 0)
                    maxDIdx = Math.max(maxDIdx, i);
                
                if (currentCap > deliveries[i - 1]) {
                    currentCap -= deliveries[i - 1];
                    deliveries[i - 1] = 0;
                    if (i == 1)
                        dIdx = 0;
                }
                else {
                    deliveries[i - 1] -= currentCap;
                    dIdx = i;
                    break;
                }
            }
            
            currentCap = cap;
            int maxPIdx = 0;
            for (int i = pIdx; i >= 1; i--) {
                if (pickups[i - 1] > 0)
                    maxPIdx = Math.max(maxPIdx, i);
                
                if (currentCap > pickups[i - 1]) {
                    currentCap -= pickups[i - 1];
                    pickups[i - 1] = 0;
                    if (i == 1)
                        pIdx = 0;
                }
                else {
                    pickups[i - 1] -= currentCap;
                    pIdx = i;
                    break;
                }
            }
            
            answer += 2 * Math.max(maxDIdx, maxPIdx);
        }
        
        return answer;
    }
}
