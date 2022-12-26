package problems.medium;

public class P55JumpGame {
    public static boolean canJump(int[] nums) {
        int n = nums.length;

        int temp = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (i + nums[i] >= temp)
                temp = i;
        }

        return temp <= 0;
    }

    public static void main(String[] args) {
        boolean p1 = canJump(new int[]{2, 3, 1, 1, 4});
        System.out.println("p1 = " + p1);

        boolean p2 = canJump(new int[]{3, 2, 1, 0, 4});
        System.out.println("p2 = " + p2);

        boolean p3 = canJump(new int[]{3, 0, 8, 2, 0, 0, 1});
        System.out.println("p3 = " + p3);
    }
}
