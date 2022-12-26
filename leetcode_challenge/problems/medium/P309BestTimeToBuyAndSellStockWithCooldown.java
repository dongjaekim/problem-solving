package problems.medium;

public class P309BestTimeToBuyAndSellStockWithCooldown {

    public static int maxProfit_best(int[] prices) {
        int n = prices.length;

        if (n < 2)
            return 0;

        int buy = -prices[0];
        int sell = 0;
        int cooldown = 0;
        for (int i = 1; i < n; i++) {
            int prev_buy = buy;
            int prev_sell = sell;
            int prev_cooldown = cooldown;

            buy = Math.max(prev_buy, prev_cooldown - prices[i]);
            sell = Math.max(prev_sell, prev_buy + prices[i]);
            cooldown = Math.max(prev_cooldown, Math.max(prev_buy, prev_sell));
        }

        return Math.max(sell, cooldown);
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;

        if (n < 2)
            return 0;

        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] cooldown = new int[n];

        buy[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            buy[i] = Math.max(buy[i - 1], cooldown[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            cooldown[i] = Math.max(cooldown[i - 1], Math.max(sell[i - 1], buy[i - 1]));
        }

        return Math.max(sell[n - 1], cooldown[n - 1]);
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
        int p1 = maxProfit_best(new int[]{1, 2, 3, 0, 2});
        System.out.println("p1 = " + p1);

        int p2 = maxProfit_best(new int[]{1});
        System.out.println("p2 = " + p2);

        int p3 = maxProfit_best(new int[]{1, 2, 4});
        System.out.println("p3 = " + p3);
    }
}
