package problems.lv0;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[] e1 = solution5(5, 555);
        int[] e2 = solution5(10, 20);

        print(e1); //[5, 50, 55, 500, 505, 550, 555]
        print(e2); //[-1]
    }
  
    public int[] solution(int l, int r) {
        List<Integer> num = new ArrayList<>();

        int cnt = 1;
        while (true) {
            int i = Integer.parseInt(Integer.toBinaryString(cnt++)) * 5;
            if (l <= i && i <= r) {
                num.add(i);
            } else if (i > r) {
                break;
            }
        }

        if (num.isEmpty()) {
            return new int[] { -1 };
        } else {
            int[] answer = new int[num.size()];
            int idx = 0;
            for (Integer i : num) {
                answer[idx++] = i;
            }

            return answer;
        }
    }
}
