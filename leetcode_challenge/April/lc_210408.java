package April;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class lc_210408 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        BestSolution best_sol = new BestSolution();

//        List<String> result = sol.letterCombinations("239");
        List<String> result = best_sol.letterCombinations("239");
        System.out.println(result);
    }
// ad ae af ba be bf ca ce cf
    public static class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> output = new ArrayList<>();

            if(digits.isEmpty() || digits.contains("1") || digits.contains("0"))
                return output;

            String[] letters = new String[digits.length()];
            for(int i = 0; i < letters.length; i++)
                letters[i] = digitToLetters(digits.charAt(i));

            List<String> temp = new ArrayList<>();
            for (String letter : letters) {
                if (output.size() == 0) {
                    for (int j = 0; j < letter.length(); j++)
                        output.add(letter.substring(j, j + 1));
                } else {
                    for (String s : output) {
                        for (int k = 0; k < letter.length(); k++)
                            temp.add(s + letter.charAt(k));
                    }
                    output.clear();
                    output.addAll(temp);
                    temp.clear();
                }
            }
            return output;
        }

        public String digitToLetters(char digit) {
            switch(digit) {
                case '2':
                    return "abc";
                case '3':
                    return "def";
                case '4':
                    return "ghi";
                case '5':
                    return "jkl";
                case '6':
                    return "mno";
                case '7':
                    return "pqrs";
                case '8':
                    return "tuv";
                case '9':
                    return "wxyz";
                default:
                    return "";
            }
        }
    }

    public static class BestSolution {
        HashMap<String, String> digitLetterMap;

        public BestSolution() {
            digitLetterMap = new HashMap<>();
            digitLetterMap.put("2", "abc");
            digitLetterMap.put("3", "def");
            digitLetterMap.put("4", "ghi");
            digitLetterMap.put("5", "jkl");
            digitLetterMap.put("6", "mno");
            digitLetterMap.put("7", "pqrs");
            digitLetterMap.put("8", "tuv");
            digitLetterMap.put("9", "wxyz");
        }


        public List<String> letterCombinations(String digits) {
            ArrayList<String> output = new ArrayList<>();

            if(digits.isEmpty() || digits.contains("0") || digits.contains("1"))
                return output;

            dfsletterCombinations(0, digits, "", output);
            return output;
        }

        public ArrayList<String> dfsletterCombinations(int depth, String digits, String letters, ArrayList<String> output) {
            if(depth == digits.length()) {
                output.add(letters);
                return output;
            }

            String digitToLetter = digitLetterMap.get(digits.substring(depth, depth+1));
            for(int i = 0; i < digitToLetter.length(); i++)
                dfsletterCombinations(depth + 1, digits, letters + digitToLetter.substring(i, i+1), output);

            return output;
        }
    }
}
