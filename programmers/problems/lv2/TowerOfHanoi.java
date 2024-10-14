package problems.lv2;

import java.util.*;

class TowerOfHanoi {
    
    public int[][] solution(int n) {
        List<int[]> answer = new ArrayList<>();
        move(n, 1, 3, 2, answer);
        return answer.toArray(new int[answer.size()][]);
    }
    
    public void move(int n, int start, int end, int between, List<int[]> answer) {
        if (n == 1) {
            answer.add(new int[] {start, end});
            return;
        }
        
        move(n - 1, start, between, end, answer);
        answer.add(new int[] {start, end});
        move(n - 1, between, end, start, answer);
    }
    
}
