package problems.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveAllAdjacentDuplicates1047 {
    public static String removeDuplicates(String s) {
        List<Character> temp = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (temp.isEmpty())
                temp.add(s.charAt(i));
            else {
                if (temp.get(temp.size() - 1) == s.charAt(i))
                    temp.remove(temp.size() - 1);
                else
                    temp.add(s.charAt(i));
            }
        }

        return temp.stream().map(c -> String.valueOf(c)).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        String output1 = removeDuplicates("abbaca");
        System.out.println("output1 = " + output1);

        String output2 = removeDuplicates("azxxzy");
        System.out.println("output2 = " + output2);
    }
}
