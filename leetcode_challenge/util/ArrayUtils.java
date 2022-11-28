package util;

import java.util.StringJoiner;

public class ArrayUtils {
    public static String Array1DToString(int[] ary) {
        StringJoiner joiner = new StringJoiner(", ");
        for (int i : ary) {
            joiner.add(String.valueOf(i));
        }
        return "[" + joiner + "]";
    }

    public static String Array2DToString(int[][] ary) {
        StringBuilder sb = new StringBuilder();
        StringJoiner sj = new StringJoiner(", ");
        sb.append("[");
        for (int i = 0; i < ary.length; i++)
            sj.add("[" + ary[i][0] + ", " + ary[i][1] + ", " + ary[i][2] + "]");
        sb.append(sj);
        sb.append("]");
        return sb.toString();
    }

    public static String convertExampleAsValidForm(String s) {
        return s.replaceAll("\\[", "{")
                .replaceAll("\\]", "}")
                .replaceAll("\"", "'");
    }
}
