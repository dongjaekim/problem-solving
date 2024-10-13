package problems.lv1;

import java.util.*;

public class PersonalityTypeTest {

    public String solution(String[] survey, int[] choices) {
        String answer = "";
        char[][] types = { { 'R', 'T' }, { 'C', 'F' }, { 'J', 'M' }, { 'A', 'N' } };
        Map<Character, Integer> score = new HashMap<>();

        for (char[] c : types) {
            score.put(c[0], 0);
            score.put(c[1], 0);
        }

        for (int i = 0; i < survey.length; i++) {
            int point = choices[i] - 4;
            char type;

            if (point == 0) {
                continue;
            } else if (point < 0) {
                type = survey[i].charAt(0);
            } else {
                type = survey[i].charAt(1);
            }

            score.put(type, score.get(type) + Math.abs(point));
        }

        for (int i = 0; i < 4; i++) {
            answer += score.get(types[i][0]) - score.get(types[i][1]) >= 0 ? types[i][0] : types[i][1];
        }

        return answer;
    }
}
