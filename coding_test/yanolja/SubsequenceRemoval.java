package yanolja;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsequenceRemoval {
    //Problem1
    public static void main(String[] args) {
        List<Integer> sample1 = subsequenceRemoval(List.of(2, 1, 3, 1, 4, 1, 3));
        System.out.println("sample1 = " + sample1);

        List<Integer> sample2 = subsequenceRemoval(List.of(1, 3, 3, 3, 1));
        System.out.println("sample2 = " + sample2);
    }

    public static List<Integer> subsequenceRemoval(List<Integer> arr) {
        Set<Integer> set = new HashSet<>();
        List<Integer> answer = new ArrayList<>();

        boolean isDescending = false;
        for (Integer i : arr) {
            if (set.contains(i)) {
                if (answer.size() == 0 || answer.get(answer.size() - 1) <= i) {
                    answer.add(i);
                } else {
                    isDescending = true;
                    break;
                }
            } else {
                set.add(i);
            }
        }

        return (answer.size() == 0 || isDescending) ? List.of(-1) : answer;
    }
}
