package problems.medium;

import java.util.Arrays;

public class P1833MaximumIceCreamBars {
    public static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int idx = 0;
        while (coins > 0 && idx < costs.length) {
            if (costs[idx] > coins)
                break;
            coins -= costs[idx];
            idx++;
        }

        return idx;
    }

    public static void main(String[] args) {
        int p1 = maxIceCream(new int[]{1, 3, 2, 4, 1}, 7);
        System.out.println("p1 = " + p1);

        int p2 = maxIceCream(new int[]{10, 6, 8, 7, 7, 8}, 5);
        System.out.println("p2 = " + p2);

        int p3 = maxIceCream(new int[]{1, 6, 3, 1, 2, 5}, 20);
        System.out.println("p3 = " + p3);
    }
}
