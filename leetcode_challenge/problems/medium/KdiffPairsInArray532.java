package problems.medium;

import java.util.*;

public class KdiffPairsInArray532 {
    public static int findPairs(int[] nums, int k) {
        int output = 0;

        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        while (left < nums.length && right < nums.length) {
            if (left == right || nums[right] - nums[left] < k)
                right++;
            else if (nums[right] - nums[left] > k)
                left++;
            else if (nums[right] - nums[left] == k) {
               output++;
               left++;
               while (left < nums.length && nums[left] == nums[left - 1])
                   left++;
            }
        }

        return output;
    }

    public static int findPairs_slow(int[] nums, int k) {
        int output = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.get(nums[i]);
            if (map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) + 1);
            else
                map.put(nums[i], 1);
        }

        if(k == 0) {
            for (Integer value : map.values()) {
                if (value > 1)
                    output++;
            }
        } else {
            for (Integer key : map.keySet()) {
                if (map.containsKey(key - k))
                    output++;
                if (map.containsKey(key + k))
                    output++;
            }
            output = output / 2;
        }

        return output;
    }

    public static void main(String[] args) {
        int pairs1 = findPairs(new int[]{3, 1, 4, 1, 5}, 2);
        System.out.println("pairs1 = " + pairs1);

        int pairs2 = findPairs(new int[]{1, 2, 3, 4, 5}, 1);
        System.out.println("pairs2 = " + pairs2);

        int pairs3 = findPairs(new int[]{1, 3, 1, 5, 4}, 0);
        System.out.println("pairs3 = " + pairs3);

        int pairs4 = findPairs(new int[]{1, 2, 4, 4, 3, 3, 0, 9, 2, 3}, 3);
        System.out.println("pairs4 = " + pairs4);

        int pairs5 = findPairs(new int[]{1, 1, 1, 1, 1}, 0);
        System.out.println("pairs5 = " + pairs5);
    }
}
