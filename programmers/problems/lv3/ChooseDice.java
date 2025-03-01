package problems.lv3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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