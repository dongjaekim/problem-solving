package problems.medium;

public class P1813SentenceSimilarity3 {

    public static void main(String[] args) {
        boolean e1 = areSentencesSimilar("My name is Haley", "My Haley"); //t
        boolean e2 = areSentencesSimilar("of", "A lot of words"); //f
        boolean e3 = areSentencesSimilar("Eating right now", "Eating"); //t
        boolean e4 = areSentencesSimilar("qbaVXO Msgr aEWD v ekcb", "Msgr aEWD ekcb"); //f
        boolean e5 = areSentencesSimilar("c h p Ny", "c BDQ r h p Ny"); //t
        boolean e6 = areSentencesSimilar("A", "a A b A"); //t
        boolean e7 = areSentencesSimilar("bb aa aa bb", "aa bb"); //t합
        //a b c d e f g    a b c d z d e f g

        System.out.println("e1 = " + e1);
        System.out.println("e2 = " + e2);
        System.out.println("e3 = " + e3);
        System.out.println("e4 = " + e4);
        System.out.println("e5 = " + e5);
        System.out.println("e6 = " + e6);
        System.out.println("e7 = " + e7);
    }

    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] _split1 = sentence1.split(" ");
        String[] _split2 = sentence2.split(" ");

        if (_split1.length > _split2.length) {
            return compare(_split2, _split1);
        } else {
            return compare(_split1, _split2);
        }
    }

    public static boolean compare(String[] shortSplit, String[] longSplit) {
        int left = 0;
        int right = 0;

        while (left < shortSplit.length && longSplit[left].equals(shortSplit[left])) {
            left++;
        }

        while (right < shortSplit.length && longSplit[longSplit.length - right - 1].equals(shortSplit[shortSplit.length - right - 1])) {
            right++;
        }

        return left + right == shortSplit.length;
    }

}
