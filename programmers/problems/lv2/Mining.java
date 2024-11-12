package problems.lv2;

import java.util.*;

class Mining {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int[][] requiredPower = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        
        int maxMinerals = 5 * (picks[0] + picks[1] + picks[2]);
        int n = Math.min(minerals.length, maxMinerals);
        List<Mineral> mineralList = new ArrayList<>();
        
        int[] count = new int[3];
        for (int i = 0; i < n; i++) {
            int idx = "diamond".equals(minerals[i]) ? 0
                : "iron".equals(minerals[i]) ? 1
                    : 2;
                    
            count[0] += requiredPower[0][idx];
            count[1] += requiredPower[1][idx];
            count[2] += requiredPower[2][idx];
            
            if (i % 5 == 4 || i == n - 1) {
                mineralList.add(new Mineral(count[0], count[1], count[2]));
                count[0] = 0;
                count[1] = 0;
                count[2] = 0;
            }
        }

        Collections.sort(mineralList, (m1, m2) -> m2.getStone() - m1.getStone());

        for (Mineral mineral : mineralList) {
            if (picks[0] > 0) {
                answer += mineral.getDiamond();
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += mineral.getIron();
                picks[1]--;
            } else {
                answer += mineral.getStone();
                picks[2]--;
            }
        }
        
        return answer;
    }
    
    class Mineral {
        private int diamond;
        private int iron;
        private int stone;
        
        public Mineral(int diamond, int iron, int stone) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }
        
        public int getDiamond() {
            return diamond;
        }
        
        public int getIron() {
            return iron;
        }
        
        public int getStone() {
            return stone;
        }
        
        @Override
        public String toString() {
            return "Mineral=("
                + "diamond=" + diamond
                + ", iron=" + iron
                + ", stone=" + stone
                + ")";
        }
    }
    
}
