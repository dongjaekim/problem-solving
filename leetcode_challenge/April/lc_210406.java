package April;

public class lc_210406 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int result = sol.minOperations(6);
        System.out.println(result);
    }

    public static class Solution {
        public int minOperations(int n) {
            int output = 0;
            int[] arr = new int[n];

            for(int i = 0; i < arr.length; i++)
                arr[i] = (2 * i) + 1;

            int idx = n / 2;
            int target = 0;
            if(n % 2 == 0)
                target = arr[idx] - 1;
            else
                target = arr[idx];

            for(int i = 0; i < idx; i++)
                output += target - arr[i];
            return output;
        }
    }

    public static class bestSolution {
        // 0 1 2 4 6 9 12 16 20
        public int minOperations(int n) {
            int num = n / 2;

            if(n % 2 == 0)
                return num * num;
            else
                return num * num + num;
        }
    }
}
