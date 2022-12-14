package problems.hard;

public class P198HouseRobber {
    public static int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (i == 1)
                dp[i] = Math.max(nums[0], nums[1]);
            else
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int p1 = rob(new int[]{1, 2, 3, 1});
        System.out.println("p1 = " + p1);

        int p2 = rob(new int[]{2, 7, 9, 3, 1});
        System.out.println("p2 = " + p2);
    }
}
