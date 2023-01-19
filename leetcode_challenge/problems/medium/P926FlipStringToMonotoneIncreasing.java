package problems.medium;

import util.ArrayUtils;

public class P926FlipStringToMonotoneIncreasing {
    public static int minFlipsMonoIncr(String s) {
        int output = s.length();
        int[] zero = new int[s.length()];
        zero[0] = s.charAt(0) == '0' ? 1 : 0;

        for (int i = 1; i < zero.length; i++)
            zero[i] = s.charAt(i) == '0' ? zero[i - 1] + 1 : zero[i - 1];

        for (int i = 0; i < s.length(); i++) {
            int leftFlip = i + 1 - zero[i];
            int rightFlip = zero[s.length() - 1] - zero[i];
            output = Math.min(output, leftFlip + rightFlip);
        }

        return Math.min(output, zero[s.length() - 1]);
    }

    public static void main(String[] args) {
        int p1 = minFlipsMonoIncr("00110");
        System.out.println("p1 = " + p1);

        int p2 = minFlipsMonoIncr("010110");
        System.out.println("p2 = " + p2);

        int p3 = minFlipsMonoIncr("00011000");
        System.out.println("p3 = " + p3);

        int p4 = minFlipsMonoIncr("11011");
        System.out.println("p4 = " + p4);
    }
}
