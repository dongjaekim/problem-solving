package problems.medium;

import util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P57InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        int[] temp = new int[2];
        temp[0] = newInterval[0];
        temp[1] = newInterval[1];
        int idx = intervals.length;
        List<int[]> intervalList = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < newStart)
                intervalList.add(intervals[i]);
            else if (intervals[i][0] > newEnd) {
                idx = i;
                break;
            } else {
                temp[0] = Math.min(intervals[i][0], temp[0]);
                temp[1] = Math.max(intervals[i][1], temp[1]);
            }
        }
        intervalList.add(temp);
        for (int i = idx; i < intervals.length; i++)
            intervalList.add(intervals[i]);

        int[][] output = new int[intervalList.size()][2];
        for (int i = 0; i < intervalList.size(); i++)
            output[i] = intervalList.get(i);

        return output;
    }

    public static void main(String[] args) {
        int[][] p1 = insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        System.out.println("p1 = " + ArrayUtils.Array2DToString(p1));

        int[][] p2 = insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
        System.out.println("p2 = " + ArrayUtils.Array2DToString(p2));

        int[][] p3 = insert(new int[][]{{1, 5}}, new int[]{2, 3});
        System.out.println("p3 = " + ArrayUtils.Array2DToString(p3));
    }
}
