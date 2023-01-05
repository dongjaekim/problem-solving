package problems.medium;

import util.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;

public class P452MinimumNumberOfArrowsToBurstBalloons {
    public static int findMinArrowShots(int[][] points) {
        int output = 0;
        Arrays.sort(points, Comparator.comparingInt(p -> p[0]));
        System.out.println("points = " + ArrayUtils.Array2DToString(points));

        if (points.length == 1)
            return 1;

        int prevEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (prevEnd >= points[i][0]) {
                if (prevEnd >= points[i][1])
                    prevEnd = points[i][1];
            } else {
                prevEnd = points[i][1];
                output++;
            }
        }

        return output + 1;
    }

    public static void main(String[] args) {
        int p1 = findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}});
        System.out.println("p1 = " + p1);

        int p2 = findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}});
        System.out.println("p2 = " + p2);

        int p3 = findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}});
        System.out.println("p3 = " + p3);
    }
}
