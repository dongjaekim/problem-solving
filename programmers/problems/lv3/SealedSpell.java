package problems.lv3;

import java.util.Arrays;

public class SealedSpell {

    public static void main(String[] args) {
        SealedSpell sealedSpell = new SealedSpell();
        String e1 = sealedSpell.solution(30, new String[] { "d", "e", "bb", "aa", "ae" });
        System.out.println("e1 = " + e1);

        String e2 = sealedSpell.solution(7388, new String[] { "gqk", "kdn", "jxj", "jxi", "fug", "jxg", "ewq", "len", "bhc" });
        System.out.println("e2 = " + e2);

        String s = sealedSpell.convertIndexToSpell(677);
        System.out.println("s = " + s);
    }

    public String solution(long n, String[] bans) {
        long[] converted = new long[bans.length];
        for (int i = 0; i < bans.length; i++) {
            converted[i] = calculateIndex(bans[i]);
        }
        Arrays.sort(converted);

        for (long idx : converted) {
            if (idx <= n)
                n++;
        }

        return convertIndexToSpell(n);
    }

    private long calculateIndex(String ban) {
        long index = 0;
        char[] toCharArray = ban.toCharArray();

        for (int i = 0; i < toCharArray.length; i++) {
            index += (long) Math.pow(26, toCharArray.length - i - 1) * (toCharArray[i] - 'a' + 1);
        }

        return index;
    }

    private String convertIndexToSpell(long index) {
        StringBuilder sb = new StringBuilder();
        while (index > 26) {
            long remainder = index % 26;
            index /= 26;

            if (remainder == 0) {
                sb.append('z');
                index--;
            } else {
                sb.append((char) (remainder - 1 + 'a'));
            }
        }
        sb.append((char) (index - 1 + 'a'));
        sb.reverse();

        return sb.toString();
    }
}
