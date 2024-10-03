package problems.medium;

import java.util.HashMap;

public class P1590MakeSumDivisibleByP {

    public static void main(String[] args) {
        int e1 = minSubarray(new int[] { 3, 1, 4, 2 }, 6); // 1
        int e2 = minSubarray(new int[] { 6, 3, 5, 2 }, 9); // 2
        int e3 = minSubarray(new int[] { 1, 2, 3 }, 3); // 0
        int e4 = minSubarray(new int[] { 1, 2, 3, 4 }, 11); // -1
        int e5 = minSubarray(new int[] { 1000000000, 1000000000, 1000000000 }, 3);
        int e6 = minSubarray(new int[] { 4, 4, 2 }, 7);
        int e7 = minSubarray(new int[] { 3, 7, 14, 15, 7, 16, 27, 7, 9, 21, 1, 17, 25, 31, 30, 28, 22 }, 59);
        int e8 = minSubarray(new int[] { 26, 19, 11, 14, 18, 4, 7, 1, 30, 23, 19, 8, 10, 6, 26, 3 }, 26);
        int e9 = minSubarray(new int[] { 8, 32, 31, 18, 34, 20, 21, 13, 1, 27, 23, 22, 11, 15, 30, 4, 2 }, 148);

        System.out.println("e1 = " + e1);
        System.out.println("e2 = " + e2);
        System.out.println("e3 = " + e3);
        System.out.println("e4 = " + e4);
        System.out.println("e5 = " + e5);
        System.out.println("e6 = " + e6);
        System.out.println("e7 = " + e7);
        System.out.println("e8 = " + e8);
        System.out.println("e9 = " + e9);
    }

    public static int minSubarray(int[] nums, int p) {
        long sum = 0;

        for (int num : nums) {
            sum += num;
        }

        int remainder = (int) (sum % p);
        if (sum < p) {
            return -1;
        } else if (remainder == 0) {
            return 0;
        } else {
            int cnt = nums.length;
            HashMap<Integer, Integer> remainderMap = new HashMap<>();
            remainderMap.put(0, -1);
            long tempSum = 0;

            for (int i = 0; i < nums.length; i++) {
                tempSum += nums[i];
                int currentMod = (int) (tempSum % p);
                int targetMod = (currentMod - remainder + p) % p;

                if (remainderMap.containsKey(targetMod)) {
                    cnt = Math.min(cnt, i - remainderMap.get(targetMod));
                }

                remainderMap.put(currentMod, i);
            }

            return cnt == nums.length ? -1 : cnt;
        }
    }
}
