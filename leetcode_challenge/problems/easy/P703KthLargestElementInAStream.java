package problems.easy;

public class P703KthLargestElementInAStream {
    class KthLargest {

        private PriorityQueue<Integer> priorityQueue;
        private int idx;

        public KthLargest(int k, int[] nums) {
            priorityQueue = new PriorityQueue<>(k);

            idx = k;
            for (int num : nums)
                add(num);
        }

        public int add(int val) {
            if (priorityQueue.size() < idx)
                priorityQueue.add(val);
            else if (priorityQueue.peek() < val) {
                priorityQueue.poll();
                priorityQueue.add(val);
            }
            System.out.println("priorityQueue = " + priorityQueue);

            return priorityQueue.peek();
        }
    }

    public static void main(String[] args) {
        KthLargest e1 = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println("e1.add(3) = " + e1.add(3));
        System.out.println("e1.add(5) = " + e1.add(5));
        System.out.println("e1.add(10) = " + e1.add(10));
        System.out.println("e1.add(9) = " + e1.add(9));
        System.out.println("e1.add(4) = " + e1.add(4));
    }
}
