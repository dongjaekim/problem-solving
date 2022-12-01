package problems.easy;

import java.util.Set;

public class P1704DetermineIfStringHalvesAreAlike {
    public static boolean halvesAreAlike(String s) {
        int splitIdx = s.length() / 2;

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        String left = s.toLowerCase().substring(0, splitIdx);
        String right = s.toLowerCase().substring(splitIdx);

        int leftCnt = 0;
        int rightCnt = 0;
        for (int i = 0; i < splitIdx; i++) {
            if (vowels.contains(left.charAt(i)))
                leftCnt++;

            if (vowels.contains(right.charAt(i)))
                rightCnt++;
        }

        return leftCnt == rightCnt;
    }

    public static void main(String[] args) {
        boolean p1 = halvesAreAlike("book");
        System.out.println("p1 = " + p1);

        boolean p2 = halvesAreAlike("textbook");
        System.out.println("p2 = " + p2);

        boolean p3 = halvesAreAlike("AbcdEfgijklmnO");
        System.out.println("p3 = " + p3);
    }
}
