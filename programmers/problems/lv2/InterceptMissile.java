package problems.lv2;

import java.util.*;

class InterceptMissile {
    
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (t1, t2) -> t1[1] - t2[1]);
        
        int temp = 0;
        for (int[] target : targets) {
            if (target[0] >= temp) {
                temp = target[1];
                answer++;
            }
        }
        
        return answer;
    }
}
