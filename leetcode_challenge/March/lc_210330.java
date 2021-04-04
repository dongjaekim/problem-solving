package March;

import java.util.Arrays;
import java.util.Comparator;

public class lc_210330 {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        int[][] envelopes = {{1,1}, {1,1}, {1,1}};
//        int[][] envelopes = {{5,4}, {6,4}, {6,7}, {2,3}};
        int[][] envelopes = {{2,100}, {3,200}, {4,300}, {5,500}, {5,400}, {5,250}, {6,370}, {6,360}, {6,380}};

        int result = sol.maxEnvelopes(envelopes);
        System.out.println(result);
    }

    public static class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            int output = 1;
            int[] dp = new int[envelopes.length];

            Comparator<int[]> envelopesComparator = new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0] > o2[0])
                        return 1;
                    else if(o1[0] == o2[0]) {
                        if(o1[1] < o2[0])
                            return 1;
                        else if(o1[1] == o2[1])
                            return 0;
                        else
                            return -1;
                    }
                    return -1;
                }
            };

            Arrays.sort(envelopes, envelopesComparator);
            dp[0] = envelopes[0][1];
            for(int i = 1; i < envelopes.length; i++) {
                if(envelopes[i][1] > dp[output - 1])
                    dp[output++] = envelopes[i][1];
                else {
                    int idx = Arrays.binarySearch(dp, 0, output, envelopes[i][1]);
                    if(idx < 0)
                        idx = -(idx + 1);
                    dp[idx] = envelopes[i][1];
                }
            }

            return output;
        }
    }
}
