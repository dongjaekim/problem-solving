package April;

public class lc_210410 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] matrix = {{3,4,5}, {3,2,6}, {2,2,1}};
        int result = sol.longestIncreasingPath(matrix);
        System.out.println(result);
    }

    public static class Solution {
        public int longestIncreasingPath(int[][] matrix) {
            int output = 0;
            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[i].length; j++) {

                }
            }

            return output;
        }

        public int findLongestPath(int[][] matrix, int startX, int startY) {
            int longestPath = 0;
            int cnt = 0;

            while(cnt < matrix.length * matrix[0].length) {

            }
            return longestPath;
        }
    }
}
