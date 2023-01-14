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
        for (int i = 0; i < 26; i++)
            equivalentChar[i] = i;

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            union(c1 - 'a', c2 - 'a');
        }

        for (int i = 0; i < baseStr.length(); i++) {
            char c = baseStr.charAt(i);
            output += (char) ('a' + find(c - 'a'));
        }

        return output;
    }

    public static int find(int x) {
        int parent = equivalentChar[x];
        if (parent != x) {
            parent = find(parent);
            equivalentChar[x] = parent;
        }
        return parent;
    }

    public static void union(int x, int y) {
        int findX = find(x);
        int findY = find(y);

        if (findX > findY)
            equivalentChar[findX] = findY;
        else if (findX < findY)
            equivalentChar[findY] = findX;
    }

    public static void main(String[] args) {
//        String p1 = smallestEquivalentString("parker", "morris", "parser");
//        System.out.println("p1 = " + p1);

//        String p2 = smallestEquivalentString("hello", "world", "hold");
//        System.out.println("p2 = " + p2);

        String p3 = smallestEquivalentString("leetcode", "programs", "sourcecode");
        System.out.println("p3 = " + p3);
    }
}
