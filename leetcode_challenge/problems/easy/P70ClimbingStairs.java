package problems.easy;

public class P70ClimbingStairs {
    public static int climbStairs(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;

        int temp = 2;
        while (temp <= n) {
            nums[temp] = nums[temp - 1] + nums[temp - 2];
            temp++;
        }
        return nums[n];
    }

    public static void main(String[] args) {
        int p1 = climbStairs(2);
        System.out.println("p1 = " + p1);

        int p2 = climbStairs(3);
        System.out.println("p2 = " + p2);

        int p3 = climbStairs(4);
        System.out.println("p3 = " + p3);

        int p4 = climbStairs(5);
        System.out.println("p4 = " + p4);
    }
}
