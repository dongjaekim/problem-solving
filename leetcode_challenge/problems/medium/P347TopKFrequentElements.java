package problems.medium;

import util.ArrayUtils;
import static util.ArrayUtils.*;

public class P347TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequentNumber = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            frequentNumber.put(nums[i], frequentNumber.getOrDefault(nums[i], 0) + 1);

        PriorityQueue<FrequentNumber> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : frequentNumber.entrySet())
            priorityQueue.add(new FrequentNumber(entry.getKey(), entry.getValue()));

        int[] output = new int[k];
        for (int j = 0; j < k; j++)
            output[j] = priorityQueue.poll().number;

        return output;
    }

    static class FrequentNumber implements Comparable<FrequentNumber>{
        private int number;
        private int count;

        public FrequentNumber(int number, int count) {
            this.number = number;
            this.count = count;
        }

        public int getNumber() {
            return number;
        }

        public int getCount() {
            return count;
        }

        @Override
        public int compareTo(FrequentNumber frequentNumber) {
            if (this.count > frequentNumber.count)
                return -1;
            else if (this.count < frequentNumber.count)
                return 1;
            else
                return 0;
        }
    }
    
    public static void main(String[] args) {
        int[] e1 = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println("ArrayUtils.Array1DToString(e1) = " + ArrayUtils.Array1DToString(e1));

        int[] e2 = topKFrequent(new int[]{1}, 1);
        System.out.println("ArrayUtils.Array1DToString(e2) = " + ArrayUtils.Array1DToString(e2));
    }
}
