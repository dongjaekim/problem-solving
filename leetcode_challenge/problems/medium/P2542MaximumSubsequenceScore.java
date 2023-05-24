package problems.medium;

public class P2542MaximumSubsequenceScore {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i] = new int[] { nums2[i], nums1[i] };
        }

        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);

        long res = 0, totalSum = 0;
        for (int[] pair : pairs) {
            pq.add(pair[1]);
            totalSum += pair[1];

            if (pq.size() > k) {
                totalSum -= pq.poll();
            }

            if (pq.size() == k) {
                res = Math.max(res, totalSum * pair[0]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        long e1 = maxScore(new int[]{1, 3, 3, 2}, new int[]{2, 1, 3, 4}, 3); // 12
        System.out.println("e1 = " + e1);

        long e2 = maxScore(new int[]{4, 2, 3, 1, 1}, new int[]{7, 5, 10, 9, 6}, 1); // 30
        System.out.println("e2 = " + e2);
    }
}
