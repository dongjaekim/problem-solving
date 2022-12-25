package problems.easy;

import util.ArrayUtils;

import java.util.Arrays;

public class P2389LongestSubsequenceWithLimitedSum {
    public static int[] answerQueries(int[] nums, int[] queries) {
        int[] answers = new int[queries.length];

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++)
            nums[i] += nums[i - 1];

        for (int i = 0; i < queries.length; i++)
            answers[i] = Math.abs(Arrays.binarySearch(nums, queries[i]) + 1);

        return answers;
    }

    public static int[] answerQueries2(int[] nums, int[] queries) {
        int[] answers = new int[queries.length];

        Arrays.sort(nums);
        for (int i = 0; i < queries.length; i++) {
            int numOfSequence = 0;
            int sum = 0;

            do {
                sum += nums[numOfSequence];
                if (sum > queries[i])
                    break;
                numOfSequence++;
            } while (numOfSequence < nums.length);
            answers[i] = numOfSequence;
        }

        return answers;
    }

    public static void main(String[] args) {
        int[] p1 = answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21});
        System.out.println("p1 = " + ArrayUtils.Array1DToString(p1));

        int[] p2 = answerQueries(new int[]{2, 3, 4, 5}, new int[]{1});
        System.out.println("p2 = " + ArrayUtils.Array1DToString(p2));
    }
}
