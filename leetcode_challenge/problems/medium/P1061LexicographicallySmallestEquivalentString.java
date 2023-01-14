package problems.medium;

import util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class P1061LexicographicallySmallestEquivalentString {
    static int[] equivalentChar = new int[26];
    
    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        String output = "";
        Arrays.fill(equivalentChar, -1);

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            union(c1 - 'a', c2 - 'a');
        }

        for (int i = 0; i < baseStr.length(); i++) {
            char c = baseStr.charAt(i);
            if (equivalentChar[c - 'a'] == -1)
                output += c;
            else
                output += (char) ('a' + equivalentChar[equivalentChar[c - 'a']]);
        }

        return output;
    }

    public static int find(int idx) {
        if (equivalentChar[idx] == -1)
            equivalentChar[idx] = idx;

        return equivalentChar[idx];
    }

    public static void union(int x, int y) {
        int findX = find(x);
        int findY = find(y);

        if (findX > findY) {
            int val = equivalentChar[findX];
            for (int i = 0; i < equivalentChar.length; i++) {
                if (equivalentChar[i] == val)
                    equivalentChar[i] = findY;
            }
            equivalentChar[findX] = findY;
        } else if (findX < findY) {
            int val = equivalentChar[findY];
            for (int i = 0; i < equivalentChar.length; i++) {
                if (equivalentChar[i] == val)
                    equivalentChar[i] = findX;
            }
            equivalentChar[findY] = findX;
        }
    }

    public static void main(String[] args) {
        String p1 = smallestEquivalentString("parker", "morris", "parser");
        System.out.println("p1 = " + p1);

        String p2 = smallestEquivalentString("hello", "world", "hold");
        System.out.println("p2 = " + p2);

        String p3 = smallestEquivalentString("leetcode", "programs", "sourcecode");
        System.out.println("p3 = " + p3);
    }
}
