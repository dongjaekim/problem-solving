package problems.medium;

import util.ArrayUtils;

public class P974SubarraySumsDivisbleByK {

    public static int subarraysDivByK(int[] nums, int k) {
        int output = 0;
        int[] subSum = new int[nums.length];
        int[] modK = new int[k];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0)
                subSum[0] = nums[0];
            else
                subSum[i] = subSum[i - 1] + nums[i];

            int mod = (subSum[i] % k + k) % k;
            if (mod == 0)
                output++;
            output += modK[mod];
            modK[mod]++;
        }
        System.out.println("subSum = " + ArrayUtils.Array1DToString(subSum));
        System.out.println("modK = " + ArrayUtils.Array1DToString(modK));

        return output;
    }

    public static void main(String[] args) {
        int p1 = subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5);
        System.out.println("p1 = " + p1);

        int p2 = subarraysDivByK(new int[]{5}, 9);
        System.out.println("p2 = " + p2);

        int p3 = subarraysDivByK(new int[]{-1, 2, 9}, 2);
        System.out.println("p3 = " + p3);

        int p4 = subarraysDivByK(new int[]{2, -2, 2, -4}, 6);
        System.out.println("p4 = " + p4);

        int p5 = subarraysDivByK(new int[]{-1, 2, 9}, 2);
        System.out.println("p5 = " + p5);
    }
}
