package problems.lv1;

import java.util.ArrayList;
import java.util.List;

public class MockTest {
    public int[] solution(int[] answers) {
        int[][] pattern = {{1, 2, 3, 4, 5},
                           {2, 1, 2, 3, 2, 4, 2, 5},
                           {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int[] correct = new int[3];

        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (pattern[j][i % pattern[j].length] == answers[i])
                    correct[j]++;
            }
        }

        int max = Math.max(correct[0], Math.max(correct[1], correct[2]));
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (correct[i] == max)
                answer.add(i + 1);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
