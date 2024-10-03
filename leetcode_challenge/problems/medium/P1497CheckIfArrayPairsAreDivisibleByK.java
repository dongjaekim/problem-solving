package problems.medium;

public class P1497CheckIfArrayPairsAreDivisibleByK {

    public static void main(String[] args) {
        boolean e1 = canArrange(new int[] { 1, 2, 3, 4, 5, 10, 6, 7, 8, 9 }, 5); //true
        boolean e2 = canArrange(new int[] { 1, 2, 3, 4, 5, 6 }, 7); //true
        boolean e3 = canArrange(new int[] { 1, 2, 3, 4, 5, 6 }, 10); //false
        boolean e4 = canArrange(new int[] { -1, 1, -2, 2, -3, 3, -4, 4 }, 3); //true
        boolean e5 = canArrange(new int[] { 5, 5, 1, 2, 3, 4 }, 10); //false
        boolean e6 = canArrange(new int[] { -1, -1, -1, -1, 2, 2, -2, -2 }, 3);

        System.out.println("e1 = " + e1);
        System.out.println("e2 = " + e2);
        System.out.println("e3 = " + e3);
        System.out.println("e4 = " + e4);
        System.out.println("e5 = " + e5);
        System.out.println("e6 = " + e6);
    }

    public static boolean canArrange(int[] arr, int k) {
        int[] remainderCount = new int[k];

        for (int i : arr) {
            int remainder = i % k;

            if (remainder < 0)
                remainder += k;

            remainderCount[remainder]++;
        }

        if (remainderCount[0] % 2 != 0)
            return false;

        for (int i = 1; i <= k / 2; i++) {
            if (remainderCount[i] != remainderCount[k - i])
                return false;
        }
        return true;
    }

}
