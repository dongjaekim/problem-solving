package problems.lv2;

import java.util.HashSet;
import java.util.Set;

public class DecodingCode {
    int[] testCode;
    int answer;

    public static void main(String[] args) {
        DecodingCode decodingCode = new DecodingCode();
        decodingCode.solution( 10, new int[1][5], new int[1]);
    }

    public int solution(int n, int[][] q, int[] ans) {
        testCode = new int[5];
        answer = 0;

        getPossibleCode(1, n, 0, q, ans);

        return answer;
    }

    public void getPossibleCode(int start, int n, int depth, int[][] q, int[] ans) {
        if (depth == 5) {
            Set<Integer> set = new HashSet<>();
            for (int num : testCode) {
                set.add(num);
            }

            for (int i = 0; i < q.length; i++) {
                int cnt = 0;
                for (int j = 0; j < 5; j++) {
                    if (set.contains(q[i][j]))
                        cnt++;
                }

                if (cnt != ans[i])
                    return;
            }

            answer++;
            return;
        }

        for (int i = start; i <= n; i++) {
            testCode[depth] = i;
            getPossibleCode(i + 1, n, depth + 1, q, ans);
        }
    }
}
