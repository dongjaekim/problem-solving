package problems.easy;

import java.util.ArrayList;
import java.util.List;

public class P1137NthTribonacciNumber {
    public static int tribonacci(int n) {
        if (n == 0)
            return 0;
        else if (n == 1 || n == 2)
            return 1;

        List<Integer> tribonacci = new ArrayList<>();
        tribonacci.add(0);
        tribonacci.add(1);
        tribonacci.add(1);
        for (int i = 2; i < n; i++) {
            int subTribonacci = tribonacci.get(i - 2) + tribonacci.get(i - 1) + tribonacci.get(i);
            tribonacci.add(subTribonacci);
        }

        return tribonacci.get(n);
    }

    public static void main(String[] args) {
        int p1 = tribonacci(4);
        System.out.println("p1 = " + p1);

        int p2 = tribonacci(25);
        System.out.println("p2 = " + p2);

        int p3 = tribonacci(35);
        System.out.println("p3 = " + p3);
    }
}
