package problems.lv4;

public class Theft {

    public static void main(String[] args) {
        Theft theft = new Theft();

        int e1 = theft.solution(new int[] { 1, 2, 3, 1 });
        System.out.println("e1 = " + e1);

        int e2 = theft.solution(new int[] { 10, 5, 3, 1, 10 });
        System.out.println("e2 = " + e2);

        int e3 = theft.solution(new int[] { 1, 2, 3 });
        System.out.println("e3 = " + e3);

        int e4 = theft.solution(new int[] { 0, 0, 2, 1, 0, 0, 1 });
        System.out.println("e4 = " + e4);

    }

    public int solution(int[] money) {
        int[][] dp = new int[2][money.length];

        dp[0][0] = money[0];
        dp[0][1] = money[0];
        dp[1][0] = 0;
        dp[1][1] = money[1];

        for (int i = 2; i < money.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 2] + money[i], dp[0][i - 1]);
            dp[1][i] = Math.max(dp[1][i - 2] + money[i], dp[1][i - 1]);
        }

        return Math.max(dp[0][money.length - 2], dp[1][money.length - 1]);
    }
}
