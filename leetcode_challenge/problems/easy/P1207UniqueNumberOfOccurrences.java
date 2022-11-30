package problems.easy;

import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class P1207UniqueNumberOfOccurrences {
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : arr)
            map.put(i, map.getOrDefault(i, 0) + 1);

        Set<Integer> collect = map.values().stream().collect(Collectors.toSet());
        return map.values().size() == collect.size();
    }

    public static void main(String[] args) {
        boolean p1 = uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3});
        System.out.println("p1 = " + p1);

        boolean p2 = uniqueOccurrences(new int[]{1, 2});
        System.out.println("p2 = " + p2);

        boolean p3 = uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0});
        System.out.println("p3 = " + p3);
    }
}
