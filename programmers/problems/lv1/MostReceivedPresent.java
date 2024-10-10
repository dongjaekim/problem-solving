import java.util.HashMap;

class MostReceivedPresent {
    public int solution(String[] friends, String[] gifts) {
        HashMap<String, Integer> idxMap = new HashMap<>();
        int n = friends.length;
        int[][] present = new int[n][n];
        int[] presentScore = new int[n];
        
        for (int i = 0; i < n; i++) {
            idxMap.put(friends[i], i);
        }
        
        for (int i = 0; i < gifts.length; i++) {
            String[] _split = gifts[i].split(" ");
            present[idxMap.get(_split[0])][idxMap.get(_split[1])]++;
            presentScore[idxMap.get(_split[0])]++;
            presentScore[idxMap.get(_split[1])]--;
        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                
                if (present[i][j] > present[j][i])
                    count++;
                else if (present[i][j] == present[j][i]) {
                    if (presentScore[i] > presentScore[j])
                        count++;
                }
            }
            
            max = Math.max(max, count);
        }
        
        return max;
    }
}
