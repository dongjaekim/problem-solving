package problems.lv3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.ArrayUtils;

public class ChooseDice {
    static int[] nums;
    static List<int[]> diceCombination;
    static int[][] diceGlobal;
    static int max;
    static int[] answer;
    static List<Integer> diceNumList;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] e1 = solution(new int[][] { { 1, 2, 3, 4, 5, 6 }, { 3, 3, 3, 3, 4, 4 }, { 1, 3, 3, 4, 4, 4 }, { 1, 1, 4, 4, 5, 5 } });
        ArrayUtils.print(e1);
        long end = System.currentTimeMillis();
        System.out.println("execution time = " + (end - start) + "ms");

//        long start2 = System.currentTimeMillis();
//        int[] e2 = solution(new int[][] { { 1, 2, 3, 4, 5, 6 }, { 2, 2, 4, 4, 6, 6 } });
//        ArrayUtils.print(e2);
//        long end2 = System.currentTimeMillis();
//        System.out.println("execution time = " + (end2 - start2) + "ms");
/*
테스트 1 〉	통과 (59.49ms, 156MB)
테스트 2 〉	통과 (9.03ms, 75.3MB)
테스트 3 〉	통과 (9.71ms, 85.6MB)
테스트 4 〉	통과 (10.06ms, 85.8MB)
테스트 5 〉	통과 (13.95ms, 84.5MB)
테스트 6 〉	통과 (15.40ms, 76.4MB)
테스트 7 〉	통과 (69.69ms, 161MB)
테스트 8 〉	통과 (62.28ms, 150MB)
테스트 9 〉	통과 (61.64ms, 147MB)
테스트 10 〉	통과 (62.94ms, 195MB)
테스트 11 〉	통과 (78.15ms, 164MB)
테스트 12 〉	통과 (117.02ms, 132MB)
테스트 13 〉	통과 (1698.00ms, 677MB)
테스트 14 〉	통과 (1930.88ms, 644MB)
테스트 15 〉	통과 (1774.05ms, 616MB)
테스트 16 〉	통과 (1746.83ms, 655MB)
테스트 17 〉	통과 (1848.30ms, 664MB)
테스트 18 〉	통과 (2063.51ms, 679MB)
테스트 19 〉	실패 (시간 초과)
테스트 20 〉	실패 (시간 초과)
테스트 21 〉	실행 중단
테스트 22 〉	실행 중단
테스트 23 〉	실행 중단
테스트 24 〉	실행 중단
테스트 25 〉	실행 중단
테스트 26 〉	실행 중단
 */
    }

    public static int[] solution(int[][] dice) {
        answer = new int[dice.length / 2];
        max = 0;
        diceGlobal = dice;
        nums = new int[dice.length / 2];
        diceCombination = new ArrayList<>();
        diceNumList = new ArrayList<>();

        comb(0,0, dice.length / 2);

        for (int[] combination : diceCombination) {
            ArrayUtils.print(combination);
        }

        for (int i = 0; i < diceCombination.size() / 2; i++) {
            int compareIdx = diceCombination.size() - i - 1;

            int[] combination = diceCombination.get(i);
            int[] compareCombination = diceCombination.get(compareIdx);

            HashMap<Integer, Integer> diceNumMap = getDiceNumMap(combination, 0, combination.length);
            HashMap<Integer, Integer> compareDiceNumMap = getDiceNumMap(compareCombination, 0, compareCombination.length);

            int winCount = 0;
            int loseCount = 0;
            for (int diceNum : diceNumMap.keySet()) {
                for (int compareDiceNum : compareDiceNumMap.keySet()) {
                    if (diceNum > compareDiceNum) {
                        winCount += diceNumMap.get(diceNum) * compareDiceNumMap.get(compareDiceNum);
                    } else if (diceNum < compareDiceNum) {
                        loseCount += diceNumMap.get(diceNum) * compareDiceNumMap.get(compareDiceNum);
                    }
                }
            }

            if (winCount > max && winCount > loseCount) {
                max = winCount;
                answer = combination;
            } else if (loseCount > max) {
                max = loseCount;
                answer = compareCombination;
            }
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i]++;
        }

        return answer;
    }

    public static void comb(int start, int curDepth, int maxDepth) {
        if (curDepth == maxDepth) {
            int[] combination = new int[maxDepth];
            for (int i = 0; i < maxDepth; i++) {
                combination[i] = nums[i];
            }
            diceCombination.add(combination);
            return;
        }

        for(int i = start; i < diceGlobal.length; i++) {
            nums[curDepth] = i;
            comb(i + 1, curDepth + 1, maxDepth);
        }
    }

    public static HashMap<Integer, Integer> getDiceNumMap(int[] combination, int curDepth, int maxDepth) {
        if (curDepth == maxDepth) {
            HashMap<Integer, Integer> diceNumMap = new HashMap<>();
            for (int diceNum : diceNumList) {
                diceNumMap.put(diceNum, diceNumMap.getOrDefault(diceNum, 0) + 1);
            }
            diceNumList.clear();
            return diceNumMap;
        }

        int idx = combination[curDepth];
        if (diceNumList.isEmpty()) {
            for (int diceNum : diceGlobal[idx]) {
                diceNumList.add(diceNum);
            }
        } else {
            int size = diceNumList.size();
            for (int i = 0; i < size; i++) {
                Integer val = diceNumList.remove(0);
                for (int diceNum : diceGlobal[idx]) {
                    diceNumList.add(diceNum + val);
                }
                System.out.println("val = " + val);
            }
        }

        return getDiceNumMap(combination, curDepth + 1, maxDepth);
    }

}