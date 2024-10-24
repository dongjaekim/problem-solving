import java.util.*;

class RepresentUsingN {
    public int solution(int N, int number) {
        List<HashSet<Integer>> dp = new ArrayList<>();
        
        if (N == number)
            return 1;
        
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }
        
        dp.get(1).add(N);
        StringBuilder sb = new StringBuilder();
        sb.append(N);
        
        for (int i = 2; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                HashSet<Integer> leftNum = dp.get(j);
                HashSet<Integer> rightNum = dp.get(i - j);
                for (Integer left : leftNum) {
                    for (Integer right : rightNum) {
                        dp.get(i).add(left + right);
                        dp.get(i).add(left - right);
                        dp.get(i).add(left * right);
                        if (right != 0)
                            dp.get(i).add(left / right);
                    }
                }
            }
            sb.append(N);
            dp.get(i).add(Integer.parseInt(sb.toString()));
        }
        
        for (int i = 1; i <= 8; i++) {
            if (dp.get(i).contains(number))
                return i;
        }
        
        return -1;
    }
}
