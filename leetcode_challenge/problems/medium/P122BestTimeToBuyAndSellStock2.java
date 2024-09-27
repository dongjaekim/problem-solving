package problems.medium;

public class P122BestTimeToBuyAndSellStock2 {

    public static void main(String[] args) {
        int c1 = maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }); //7
        int c2 = maxProfit(new int[] { 1, 2, 3, 4, 5 }); //4
        int c3 = maxProfit(new int[] { 7, 6, 4, 3, 1 }); //0

        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
        System.out.println("c3 = " + c3);
    }

    public static int maxProfit(int[] prices) {
        return calc(0, prices);
    }

    public static int calc(int day, int[] prices) {
        if (day >= prices.length - 1)
            return 0;

        int max = 0;

        for (int i = day; i < prices.length - 1; i++) {
            int profit = prices[i + 1] - prices[i];
            if (profit >= max && profit != 0) {
                max = profit + calc(i + 1, prices);
            }
        }

        return max;
    }

}
