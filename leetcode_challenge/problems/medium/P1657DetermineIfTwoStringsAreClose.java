package problems.medium;

import java.util.*;
import java.util.stream.Collectors;

public class P1657DetermineIfTwoStringsAreClose {
    public static boolean closeStrings2(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        Map<Character, Integer> word1CharCntMap = new HashMap<>();
        Map<Character, Integer> word2CharCntMap = new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            word1CharCntMap.put(word1.charAt(i), word1CharCntMap.getOrDefault(word1.charAt(i), 0) + 1);
            word2CharCntMap.put(word2.charAt(i), word2CharCntMap.getOrDefault(word2.charAt(i), 0) + 1);
        }
        System.out.println("word1CharCntMap = " + word1CharCntMap);
        System.out.println("word2CharCntMap = " + word2CharCntMap);
        if (word1CharCntMap.keySet().size() != word2CharCntMap.size())
            return false;

        List<Integer> word2Values = word2CharCntMap.values().stream().collect(Collectors.toList());
        for (Map.Entry<Character, Integer> word1Entry : word1CharCntMap.entrySet()) {
            if (!word2CharCntMap.containsKey(word1Entry.getKey()))
                return false;
            word2Values.remove(word1Entry.getValue());
        }

        return word2Values.size() == 0;
    }

    public static boolean closeStrings(String word1, String word2) {
        int[] word1CharCnt = new int[26];
        int[] word2CharCnt = new int[26];

        if (word1.length() != word2.length())
            return false;

        for (int i = 0; i < word1.length(); i++) {
            word1CharCnt[word1.charAt(i) - 'a']++;
            word2CharCnt[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < word1CharCnt.length; i++) {
            if (word1CharCnt[i] == 0 && word2CharCnt[i] > 0)
                return false;

            if (word2CharCnt[i] == 0 && word1CharCnt[i] > 0)
                return false;
        }

        Arrays.sort(word1CharCnt);
        Arrays.sort(word2CharCnt);
        return Arrays.equals(word1CharCnt, word2CharCnt);
    }

    public static void main(String[] args) {
        boolean p1 = closeStrings("abc", "bca");
        System.out.println("p1 = " + p1);

        boolean p2 = closeStrings("a", "aa");
        System.out.println("p2 = " + p2);

        boolean p3 = closeStrings("cabbba", "abbccc");
        System.out.println("p3 = " + p3);

        boolean p4 = closeStrings("aaabbbbccddeeeeefffff", "aaaaabbcccdddeeeeffff");
        System.out.println("p4 = " + p4);
    }
}
