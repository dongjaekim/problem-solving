package problems;

import java.util.HashMap;
import java.util.Map;

public class makeRectangle {
    public static int[] solution(int[][] v) {
        int[] answer = new int[2];

        Map<Integer, Integer> xCnt = new HashMap<>();
        Map<Integer, Integer> yCnt = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            xCnt.put(v[i][0], xCnt.getOrDefault(v[i][0], 0) + 1);
            yCnt.put(v[i][1], yCnt.getOrDefault(v[i][1], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : xCnt.entrySet()) {
            if (entry.getValue() == 1)
                answer[0] = entry.getKey();
        }

        for (Map.Entry<Integer, Integer> entry : yCnt.entrySet()) {
            if (entry.getValue() == 1)
                answer[1] = entry.getKey();
        }

        return answer;
    }
    
    public static int[] bestSolution(int[][] v) {
        int[] output = new int[2];
        int x = v[0][0] ^ v[1][0] ^ v[2][0];
        int y = v[0][1] ^ v[1][1] ^ v[2][1];
        output[0] = x;
        output[1] = y;
        return output;
    }

    public static void main(String[] args) {
        int[][] p1 = {{1, 2}, {2, 10}, {2, 2}};
        int[] solution = solution(p1);
        System.out.println("solution[0] + \"//\" + solution[1] = " + solution[0] + "//" + solution[1]);

        int[] bestSolution = bestSolution(p1);
        System.out.println("bestSolution[0] + \"//\" + bestSolution[1] = " + bestSolution[0] + "//" + bestSolution[1]);
    }

}
