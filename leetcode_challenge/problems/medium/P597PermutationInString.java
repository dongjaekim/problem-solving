package problems.medium;

import java.util.Arrays;
import java.util.stream.Collectors;

public class P597PermutationInString {

    public static void main(String[] args) {
        boolean e1 = checkInclusion("ab", "eidbaooo");
        boolean e2 = checkInclusion("ab", "eidboaoo");
        boolean e3 = checkInclusion("adc", "dcda");
        boolean e4 = checkInclusion("ccc", "cbac");
        boolean e5 = checkInclusion("abc", "bbbca");
        boolean e6 = checkInclusion("trinitrophenylmethylnitramine", "dinitrophenylhydrazinetrinitrophenylmethylnitramine");

        System.out.println("e1 = " + e1); //t
        System.out.println("e2 = " + e2); //f
        System.out.println("e3 = " + e3); //t
        System.out.println("e4 = " + e4); //f
        System.out.println("e5 = " + e5); //t
        System.out.println("e6 = " + e6); //t
    }

    public static boolean checkInclusion(String s1, String s2) {
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        if (s1.length() > s2.length())
            return false;

        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int freq = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i])
                freq++;
        }

        if (freq == 26)
            return true;

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int left = i;
            int right = i + s1.length();

            s2Count[s2.charAt(right) - 'a']++;
            if (s1Count[s2.charAt(right) - 'a'] == s2Count[s2.charAt(right) - 'a'])
                freq++;
            else if (s1Count[s2.charAt(right) - 'a'] + 1 == s2Count[s2.charAt(right) - 'a'])
                freq--;

            s2Count[s2.charAt(left) - 'a']--;
            if (s1Count[s2.charAt(left) - 'a'] == s2Count[s2.charAt(left) - 'a'])
                freq++;
            else if(s1Count[s2.charAt(left) - 'a'] - 1 == s2Count[s2.charAt(left) - 'a'])
                freq--;

            if (freq == 26)
                return true;
        }

        return false;
    }

    public static void print(int[] arr) {
        System.out.print("[");
        System.out.print(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        System.out.println("]");
    }
}
