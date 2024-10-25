package problems.lv2;

import java.util.*;

class TargetNumber {
    public int solution(int[] numbers, int target) {
        int[] negate = new int[numbers.length];
        Arrays.fill(negate, 1);
        
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        
        return sum == target ? 1 : dfs(numbers, target, negate, 0);
    }
    
    public int dfs(int[] numbers, int target, int[] negate, int idx) {
        if (idx == numbers.length)
            return 0;
            
        int sum = 0;
        int result = 0;

        negate[idx] = -1;        
        for (int i = 0; i < numbers.length; i++) {
            sum += negate[i] * numbers[i];
        }
        
        if (sum == target) 
            result++;
        
        result += dfs(numbers, target, negate, idx + 1);
        negate[idx] = 1;
        result += dfs(numbers, target, negate, idx + 1);
                
        return result;
    }
}
