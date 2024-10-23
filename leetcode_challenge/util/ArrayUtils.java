package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class ArrayUtils {

    public static void print(Object[] ary) {
        System.out.print("[");
        System.out.print(Arrays.stream(ary).map(String::valueOf).collect(Collectors.joining(",")));
        System.out.println("]");
    }

    public static void print(int[] ary) {
        System.out.print("[");
        System.out.print(Arrays.stream(ary).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        System.out.println("]");

        List<Integer> i = new ArrayList<>();

    }

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
            sj.add(Array1DToString(ary[i]));
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
