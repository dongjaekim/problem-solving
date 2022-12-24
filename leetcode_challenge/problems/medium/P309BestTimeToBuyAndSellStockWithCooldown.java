package problems.medium;

public class P309BestTimeToBuyAndSellStockWithCooldown {

    public static int maxProfit(int[] prices) {
        return dfs(prices, -1, 0, 0, false);
    }

    public static int dfs(int[] prices, int buy, int profit, int day, boolean isSoldYesterday) {
        if (day == prices.length - 1) {
            if (isSoldYesterday) {
                return profit;
            } else {
                if (buy != -1)
                    return profit + prices[day];
                else
                    return profit;
            }
        }

        int cooldownProfit = 0;
        int sellProfit = 0;
        int buyProfit = 0;

        if (isSoldYesterday) {
            // cooldown
            cooldownProfit = dfs(prices, buy, profit, day + 1, false);

            // sell
            if (buy != -1 && buy < prices[day])
                sellProfit = dfs(prices, -1, profit + prices[day] - buy, day + 1, true);
        } else {
            if (buy == -1) {
                // cooldown
                cooldownProfit = dfs(prices, buy, profit, day + 1, false);

                // buy
                buyProfit = dfs(prices, prices[day], profit - prices[day], day + 1, false);
            } else {
                // cooldown
                cooldownProfit = dfs(prices, buy, profit, day + 1, false);

                // sell & buy
                if (buy < prices[day]) {
                    sellProfit = dfs(prices, -1, profit + prices[day], day + 1, true);
                    buyProfit = dfs(prices, prices[day], profit - prices[day], day + 1, true);
                }
            }
        }
        return Math.max(Math.max(cooldownProfit, sellProfit), buyProfit);
    }

    public static void main(String[] args) {
        int p1 = maxProfit(new int[]{1, 2, 3, 0, 2});
        System.out.println("p1 = " + p1);

        int p2 = maxProfit(new int[]{1});
        System.out.println("p2 = " + p2);

        int p3 = maxProfit(new int[]{1, 2, 4});
        System.out.println("p3 = " + p3);
    }
}
