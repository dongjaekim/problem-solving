package problems.medium;

import java.util.*;
import java.util.stream.Collectors;

public class P2616MinimizeTheMaximumDifferenceOfPairs {
    public static int minimizeMax(int[] nums, int p) {
        int max = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        PriorityQueue<NumCount> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            priorityQueue.add(new NumCount(entry.getKey(), entry.getValue()));
        System.out.println("priorityQueue = " + priorityQueue);
        for (int i = 0; i < p; i++) {
            NumCount poll = priorityQueue.poll();
            if (poll.getCount() > 2) {
                poll.setCount(poll.getCount() - 2);
                priorityQueue.add(poll);
            } else if (poll.getCount() < 2) {
                NumCount poll1 = priorityQueue.poll();
                max = Math.max(max, poll1.getNum() - poll.getNum());
            }
        }

        return max;
    }

    static class NumCount implements Comparable<NumCount> {
        private int num;
        private int count;

        public NumCount(int num, int count) {
            this.num = num;
            this.count = count;
        }

        public int getNum() {
            return this.num;
        }

        public int getCount() {
            return this.count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public int compareTo(NumCount numCount) {
            if (this.count > numCount.getCount())
                return -1;
            else if (this.count == numCount.count) {
                if (this.num > numCount.getNum())
                    return 1;
                else if (this.num < numCount.getNum())
                    return -1;
                return 0;
            } else if (this.count < numCount.getCount())
                return 1;
            return 0;
        }
    }

    public static int minimizeMaxBest(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, r = nums[n - 1] - nums[0] + 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (count(nums, mid) >= p)
                r = mid;
            else
                l = mid + 1;
        }

        return l;
    }
    
    private static int count(int[] nums, int diff) {
        int cnt = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] <= diff) {
                cnt++;
                i++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int p1 = minimizeMaxBest(new int[]{10, 1, 2, 7, 1, 3}, 2);
        System.out.println("p1 = " + p1);

        int p2 = minimizeMaxBest(new int[]{4, 2, 1, 2}, 1);
        System.out.println("p2 = " + p2);

        int p3 = minimizeMaxBest(new int[]{5, 6, 0, 5, 4, 0, 0}, 1);
        System.out.println("p3 = " + p3);

        int p4 = minimizeMaxBest(new int[]{8, 9, 1, 5, 4, 3, 6, 4, 3, 7}, 4);
        System.out.println("p4 = " + p4);
    }
}
