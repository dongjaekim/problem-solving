package problems.medium;

public class P91DecodeWays {
    public static int numDecodings(String s) {
        if(s.length() > 100 || s.startsWith("0"))
            return 0;
        else if(s.length() == 1)
            return 1;
        else if(s.length() == 2) {
            if (Integer.parseInt(s) <= 26) {
                if(s.endsWith("0")) {
                    return 1;
                } else {
                    return 2;
                }
            } else {
                if(s.endsWith("0")) {
                    return 0;
                } else {
                    return 1;
                }
            }
        }

        if(Integer.parseInt(s.substring(0, 2)) <= 26)
            return numDecodings(s.substring(1)) + numDecodings(s.substring(2));
        else
            return numDecodings(s.substring(1));
    }

    public static int numDecodings2(String s) {
        int[] ary = new int[s.length()];

        if (s.charAt(0) != '0')
            ary[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            int oneDigit = s.charAt(i) - '0';
            int twoDigit = (s.charAt(i - 1) - '0') * 10 + oneDigit;

            if (oneDigit != 0)
                ary[i] += ary[i - 1];
            if (twoDigit >= 10 && twoDigit <= 26)
                ary[i] += (i >= 2) ? ary[i - 2] : 1;
        }

        return ary[s.length() - 1];
    }

    @Deprecated
    public static int dp(String s, int[] ary, int idx) {
        if(idx >= s.length() - 2)
            return ary[idx];

        String substring = s.substring(idx, idx + 2);

        if(!substring.startsWith("0") && Integer.parseInt(substring) <= 26)
            ary[idx] = dp(s, ary, idx + 1) + dp(s, ary, idx + 2);
        else
            ary[idx] = dp(s, ary, idx + 1);

        return ary[idx];
    }

    public static void main(String[] args) {
        int i = numDecodings2("11106");
        System.out.println("i = " + i);

        int i1 = numDecodings2("12");
        System.out.println("i1 = " + i1);

        int i2 = numDecodings2("226");
        System.out.println("i2 = " + i2);

        int i3 = numDecodings2("06");
        System.out.println("i3 = " + i3);

        int i4 = numDecodings2("11116");
        System.out.println("i4 = " + i4);

        int i5 = numDecodings2("123123");
        System.out.println("i5 = " + i5);

        int i6 = numDecodings2("111111111111111111111111111111111111111111111");
        System.out.println("i6 = " + i6);

        /**
         * i = 2
         * i1 = 2
         * i2 = 3
         * i3 = 0
         * i4 = 8
         * i5 = 9
         * i6 = 1836311903
         */
    }
}
