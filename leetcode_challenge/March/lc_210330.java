package March;

public class lc_210330 {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        int[][] envelopes = {{1,1}, {1,1}, {1,1}};
        int[][] envelopes = {{5,4}, {6,4}, {6,7}, {2,3}};

        int result = sol.maxEnvelopes(envelopes);
        System.out.println(result);
    }

    public static class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            int output = 0;
            int[][] sortedEnvelopes = new int[envelopes.length][envelopes[0].length];

            // too hard..

            return output;
        }
    }
}
