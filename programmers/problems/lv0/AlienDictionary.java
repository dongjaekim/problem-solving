package problems.lv0;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AlienDictionary {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        Map<String, Integer> map = new HashMap<>();
        for (String s : spell) {
            map.put(s, 1);
        }

        for (String compare : dic) {
            Set<String> set = new HashSet<>();
            for (int i = 0; i < compare.length(); i++) {
                String subStr = compare.substring(i, i + 1);
                if (map.get(subStr) == null) {
                    set.clear();
                    break;
                } else
                    set.add(subStr);
            }

            if (set.size() == map.size()) {
                answer = 1;
                break;
            }
        }
        return answer;
    }
}
