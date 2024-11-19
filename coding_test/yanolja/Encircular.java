package yanolja;

import java.util.ArrayList;
import java.util.List;

public class Encircular {
    //Problem2
    public static void main(String[] args) {
        List<String> sample1 = doesCircleExist(List.of("G", "L", "GRGRGRGR", "GRGRGRGRG"));
        System.out.println("sample1 = " + sample1);
    }

    public static List<String> doesCircleExist(List<String> commands) {
        List<String> answer = new ArrayList<>();
        final String YES = "YES";
        final String NO = "NO";

        for (String command : commands) {
            if (containsOnlyG(command)) {
                answer.add(NO);
            } else if (command.length() == 1) {
                answer.add(YES);
            } else {
                int LCount = 0;
                int RCount = 0;

                for (int i = 0; i < command.length(); i++) {
                    if (command.charAt(i) == 'L')
                        LCount++;
                    else if (command.charAt(i) == 'R')
                        RCount++;
                }

                if (LCount == RCount) {
                    answer.add(NO);
                } else {
                    answer.add(YES);
                }
            }
        }

        return answer;
    }

    public static boolean containsOnlyG(String command) {
        if (command.indexOf("L") < 0 && command.indexOf("R") < 0)
            return true;
        else
            return false;
    }
}
