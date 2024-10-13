package problems.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MenuRenewal {

    public static void main(String[] args) {
        solution(new String[] { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" }, new int[] { 2, 3, 4 });
    }

    public static String[] solution(String[] orders, int[] course) {
        List<String> menu = new ArrayList<>();

        Arrays.sort(orders, (s1, s2) -> s2.length() - s1.length());
        for (int length : course) {
            Map<String, Integer> freq = new HashMap<>();
            int max = 0;

            for (String order : orders) {
                if (order.length() < length)
                    break;

                char[] charArray = order.toCharArray();
                Arrays.sort(charArray);
                order = new String(charArray);

                dfs(freq, order, "", length, 0, 0);
            }

            max = freq.values().stream().max(Integer::compare).orElse(0);
            if (max <= 1)
                continue;

            for (Entry<String, Integer> entry : freq.entrySet()) {
                if (entry.getValue() == max)
                    menu.add(entry.getKey());
            }
        }

        String[] answer = menu.toArray(new String[menu.size()]);
        Arrays.sort(answer);
        return answer;
    }

    public static void dfs(Map<String, Integer> freq, String order, String course, int length, int index, int depth) {
        if (depth == length) {
            freq.put(course, freq.getOrDefault(course, 0) + 1);
            return;
        }

        for (int i = index; i < order.length(); i++) {
            dfs(freq, order, course + order.charAt(i), length, i + 1, depth + 1);
        }
    }
}
