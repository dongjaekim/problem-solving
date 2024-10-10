package problems.lv0;

import java.util.*;
import java.util.Map.*;
import java.util.stream.Collectors;

class ContestAttendeeRank {
    public static void main(String[] args) {
        int e1 = solution(new int[] { 3, 7, 2, 5, 4, 6, 1 },
            new boolean[] { false, true, true, true, true, false, false });
        int e2 = solution(new int[] { 1, 2, 3 },
            new boolean[] { true, true, true });
        int e3 = solution(new int[] { 6, 1, 5, 2, 3, 4 },
            new boolean[] { true, false, true, false, false, true });

        System.out.println("e1 = " + e1); //20403
        System.out.println("e2 = " + e2); //102
        System.out.println("e3 = " + e3); //50200
    }
  
    public static int solution(int[] rank, boolean[] attendance) {
        Map<Integer, Integer> attendableRank = new HashMap<>();
        
        for (int i = 0; i < attendance.length; i++) {
            if (attendance[i]) {
                attendableRank.put(i, rank[i]);
            }        
        }

        List<Entry<Integer, Integer>> sortedRank = attendableRank.entrySet().stream()
            .sorted(Comparator.comparingInt(Entry::getValue))
            .collect(Collectors.toList());

        return 10000 * sortedRank.get(0).getKey() 
            + 100 * sortedRank.get(1).getKey() + sortedRank.get(2).getKey();
    }
}
