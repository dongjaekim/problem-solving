package problems.medium;

import java.util.Collections;
import java.util.PriorityQueue;

public class P215KthLargestElementInAnArray {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++)
            priorityQueue.add(nums[i]);

        for (int j = 0; j < k - 1; j++)
            priorityQueue.poll();

        return priorityQueue.poll();
    }

    public static void main(String[] args) {
        int p1 = findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println("p1 = " + p1);

        int p2 = findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
        System.out.println("p2 = " + p2);
    }
}
