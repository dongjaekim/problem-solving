package April;

public class lc_210409 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] words = {"world", "world", "row"};
        String order = "worldabcefghijkmnpqstuvxyz";
        boolean result = sol.isAlienSorted(words, order);
        System.out.println(result);
    }

    public static class Solution {
        public boolean isAlienSorted(String[] words, String order) {
            for(int i = 0; i < words.length - 1; i++) {
                String first = words[i];
                String second = words[i+1];
                int minLength = Math.min(first.length(), second.length());

                for(int j = 0; j < minLength; j++) {
                    int idx_first = order.indexOf(first.charAt(j));
                    int idx_second = order.indexOf(second.charAt(j));

                    if(idx_first < idx_second)
                        break;
                    else if(idx_first == idx_second)
                        continue;
                    else
                        return false;
                }

                if(first.substring(0, minLength).equals(second.substring(0, minLength)) && first.length() > second.length())
                    return false;
            }
            return true;
        }
    }
}
