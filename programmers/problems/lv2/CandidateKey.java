package problems.lv2;

import java.util.*;

class CandidateKey {
    public int solution(String[][] relation) {
        List<String> candidates = new ArrayList<>();
        
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < relation[0].length; i++) 
            queue.offer(String.valueOf(i));
        
        while (!queue.isEmpty()) {
            String candidate = queue.poll();
            char[] indexArr = candidate.toCharArray();
            
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < relation.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < indexArr.length; j++) {
                    sb.append(relation[i][indexArr[j] - '0']);
                }
                set.add(sb.toString());
            }
            
            if (set.size() == relation.length) {
                boolean isNew = true;
                for (String c : candidates){
                    int count = 0;
                    String[] _split = c.split("");         
                    for (String s : _split) {
                        if (candidate.contains(s)) {
                            count++;
                        }
                    }
                    if (count == c.length())
                        isNew = false;
                }
                
                if (isNew)
                    candidates.add(candidate);
            } else {
                int lastIdx = indexArr[indexArr.length - 1] - '0' + 1;
                for (int i = lastIdx; i < relation[0].length; i++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(candidate);
                    sb.append(i);
                    queue.offer(sb.toString());
                }   
            }
        }
        
        return candidates.size();
    }
}
