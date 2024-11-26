package problems.lv3;

import java.util.*;

class ConvertWord {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int n = words.length;
        int len = begin.length();
        Queue<Item> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        queue.offer(new Item(begin, 0));
        while (!queue.isEmpty()) {
            Item item = queue.poll();
            String word = item.getWord();
            Integer step = item.getStep();
            
            if (target.equals(word)) {
                answer = step;
                break;
            }
            
            for (int i = 0; i < words.length; i++) {
                int cnt = 0;
                for (int j = 0; j < len; j++) {
                    if (word.charAt(j) != words[i].charAt(j))
                        cnt++;
                }
                
                if (cnt == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(new Item(words[i], step + 1));
                }
            }
        }
        
        return answer;
    }
    
    static class Item {
        private String word;
        private Integer step;
        
        public Item(String word, Integer step) {
            this.word = word;
            this.step = step;
        }
        
        public Integer getStep() {
            return this.step;
        }
        
        public String getWord() {
            return this.word;
        }
    }
}
