package problems.medium;

import util.ArrayUtils;

import java.util.Arrays;

public class P2279MaximumBagsWithFullCapacityOfRocks {
    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int output = 0;
        int n = capacity.length;

        for (int i = 0; i < n; i++)
            capacity[i] -= rocks[i];

        Arrays.sort(capacity);
        System.out.println("capacity = " + ArrayUtils.Array1DToString(capacity));

        while (output < n) {
            additionalRocks -= capacity[output];
            if (additionalRocks < 0)
                break;
            output++;
        }

        return output;
    }

    public static void main(String[] args) {
        int p1 = maximumBags(new int[]{2, 3, 4, 5}, new int[]{1, 2, 4, 4}, 2);
        System.out.println("p1 = " + p1);

        int p2 = maximumBags(new int[]{10, 2, 2}, new int[]{2, 2, 0}, 100);
        System.out.println("p2 = " + p2);

        int p3 = maximumBags(new int[]{91, 54, 63, 99, 24, 45, 78}, new int[]{35, 32, 45, 98, 6, 1, 25}, 17);
        System.out.println("p3 = " + p3);
    }
}
