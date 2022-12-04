package problems.medium;

import java.util.Arrays;

public class P2256MinimumAverageDifference {
    public static int minimumAverageDifference(int[] nums) {
        int idx = 0;
        int min = Integer.MAX_VALUE;

        long leftTemp = 0;
        long total = 0;
        for (int i = 0; i < nums.length; i++)
            total += nums[i];

        for (int i = 0; i < nums.length; i++) {
            leftTemp += nums[i];
            total -= nums[i];
            int left = Math.round(leftTemp / (i + 1));
            int right = (i + 1) == nums.length ? 0 : Math.round(total / (nums.length - (i + 1)));

            if (min > Math.abs(left - right)) {
                idx = i;
                min = Math.abs(left - right);
            }
        }

        return idx;
    }

    public static void main(String[] args) {
        int p1 = minimumAverageDifference(new int[]{2, 5, 3, 9, 5, 3});
        System.out.println("p1 = " + p1);

        int p2 = minimumAverageDifference(new int[]{0});
        System.out.println("p2 = " + p2);
    }
}
