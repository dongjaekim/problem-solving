package April;

public class lc_210405 {
    // global and local inversions
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] input = {1, 2, 0};
        boolean result = sol.isIdealPermutation(input);
        System.out.println(result);
    }

    public static class Solution {
        public boolean isIdealPermutation(int[] A) {
            for(int i = 0; i < A.length; i++) {
                for(int j = i + 2; j < A.length; j++) {
                    if(A[i] > A[j])
                        return false;
                }
            }

            return true;
        }
    }

    public static class bestSolution {
        public boolean isIdealPermutation(int[] A) {
            for(int i = 0; i < A.length; i++) {
                if(Math.abs(A[i] - i) > 1)
                    return false;
            }
            return true;
        }
    }
}
