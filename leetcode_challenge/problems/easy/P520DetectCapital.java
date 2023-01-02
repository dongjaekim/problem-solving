package problems.easy;

public class P520DetectCapital {
    public static boolean detectCapitalUse(String word) {
        boolean isLower = Character.isLowerCase(word.charAt(0));

        if (word.length() == 1)
            return true;

        char prev = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            if (isLower) {
                if (Character.isUpperCase(word.charAt(i)))
                    return false;
            } else {
                if (Character.isLowerCase(word.charAt(i))) {
                    if (Character.isUpperCase(prev) && i != 1)
                        return false;
                } else {
                    if (Character.isLowerCase(prev))
                        return false;
                }
                prev = word.charAt(i);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean p1 = detectCapitalUse("USA");
        System.out.println("p1 = " + p1);

        boolean p2 = detectCapitalUse("leetcode");
        System.out.println("p2 = " + p2);

        boolean p3 = detectCapitalUse("FlaG");
        System.out.println("p3 = " + p3);
    }
}
