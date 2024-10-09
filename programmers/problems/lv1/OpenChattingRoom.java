package problems.lv1;

import static util.ArrayUtils.print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class OpenChattingRoom {

    public static void main(String[] args) {
        String[] e1 = solution(
                new String[] { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan" });
        print(e1);
    }

    public static String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String, String> userInfo = new HashMap<>();

        for (String r : record) {
            String[] _split = r.split(" ");
            if ("Enter".equals(_split[0])) {
                answer.add(enter(_split[1]));
                userInfo.put(_split[1], _split[2]);
            } else if ("Leave".equals(_split[0])) {
                answer.add(leave(_split[1]));
            } else if ("Change".equals(_split[0])) {
                userInfo.put(_split[1], _split[2]);
            }
        }

        String[] answerAry = new String[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            String str = answer.get(i);
            String uid = str.substring(0, str.indexOf("님이 "));
            answerAry[i] = str.replace(uid, userInfo.get(uid));
        }

        return answerAry;
    }

    private static String enter(String nick) {
        return String.format("%s님이 들어왔습니다.", nick);
    }

    private static String leave(String nick) {
        return String.format("%s님이 나갔습니다.", nick);
    }
}
