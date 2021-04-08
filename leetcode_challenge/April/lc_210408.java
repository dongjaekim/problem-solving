package April;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lc_210408 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        List<String> result = sol.letterCombinations("239");
        System.out.println(result);
    }
// ad ae af ba be bf ca ce cf
    public static class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> output = new ArrayList<String>();

            if(digits.isEmpty() || digits.contains("1") || digits.contains("0"))
                return output;

            String[] letters = new String[digits.length()];
            for(int i = 0; i < letters.length; i++)
                letters[i] = digitToLetters(digits.charAt(i));

            List<String> temp = new ArrayList<String>();
            for(int i = 0; i < letters.length; i++) {
                if(output.size() == 0) {
                    for(int j = 0; j < letters[i].length(); j++)
                        output.add(letters[i].substring(j, j+1));
                } else {
                    for(int j = 0; j < output.size(); j++) {
                        for(int k = 0; k < letters[i].length(); k++)
                            temp.add(output.get(j) + letters[i].substring(k, k+1));
                    }
                    output.clear();
                    for(int n = 0; n < temp.size(); n++)
                        output.add(temp.get(n));
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
}
