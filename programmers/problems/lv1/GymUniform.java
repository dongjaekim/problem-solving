package problems.lv1;

import java.util.*;

public class GymUniform {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostStudent = new HashSet<>();
        Set<Integer> reserveStudent = new HashSet<>();
        int rescuedCount = 0;

        for (int i : lost) {
            lostStudent.add(i);
        }

        for (int i : reserve) {
            if (lostStudent.contains(i))
                lostStudent.remove(i);
            else
                reserveStudent.add(i);
        }

        for (int ls : lostStudent) {
            for (int rs : reserveStudent) {
                if (ls - 1 == rs || ls + 1 == rs) {
                    reserveStudent.remove(rs);
                    rescuedCount++;
                    break;
                }
            }
        }

        return n - lostStudent.size() + rescuedCount;
    }
}
