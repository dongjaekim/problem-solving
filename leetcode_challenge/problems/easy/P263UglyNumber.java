package problems.easy;

public class P263UglyNumber {
    public static boolean isUgly(int n) {
        if (n <= 0)
            return false;

        while (n != 1) {
            if (n % 2 == 0)
                n = n / 2;
            else if (n % 3 == 0)
                n = n / 3;
            else if (n % 5 == 0)
                n = n / 5;
            else
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        boolean p1 = isUgly(6);
        System.out.println("p1 = " + p1);

        boolean p2 = isUgly(1);
        System.out.println("p2 = " + p2);

        boolean p3 = isUgly(14);
        System.out.println("p3 = " + p3);
    }
}
