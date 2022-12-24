package problems.medium;

public class P790DominoAndTrominoTiling {
    public static int numTilings(int n) {
        int output = 1;

        int divider2 = n / 2;
        int divider3 = n / 3;

        for (int i = 1; i <= divider2; i++)
            output += combination(n - 2 * i + i, i);

        System.out.println("output = " + output);
/*
    1
    1 + 1
    1 + 2
    1 + 3 + 1
    1 + 4 + 3
    1 + 5 + 6 + 1
    1 + 6 + 10 + 4
    1 + 7 + 15 + 10 + 1
        1 2 3 5 8 13 21 34
*/

        return output % ((int) Math.pow(10, 9) + 7);
    }

    public static int combination(int x, int y) {
        int output = 1;
        for (int i = 0; i < y; i++)
            output *= (x - i);
        for (int j = 1; j <= y; j++)
            output /= j;
        return output;
    }

    public static void main(String[] args) {
        int p1 = numTilings(3);
        System.out.println("p1 = " + p1);

        int p2 = numTilings(1);
        System.out.println("p2 = " + p2);

        int p3 = numTilings(5);
        System.out.println("p3 = " + p3);
    }
}
