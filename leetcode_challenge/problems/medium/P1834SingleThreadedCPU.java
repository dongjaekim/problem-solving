package problems.medium;

import util.ArrayUtils;

import java.util.*;

public class P1834SingleThreadedCPU {
    public static int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] output = new int[n];
        int[][] taskWithIndex = new int[n][3];
        for (int i = 0; i < n; i++) {
            taskWithIndex[i][0] = tasks[i][0];
            taskWithIndex[i][1] = tasks[i][1];
            taskWithIndex[i][2] = i;
        }

        Arrays.sort(taskWithIndex, Comparator.comparingInt(a -> a[0]));
        System.out.println("taskWithIndex = " + ArrayUtils.Array2DToString(taskWithIndex));

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int startTime = taskWithIndex[0][0];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (startTime == taskWithIndex[i][0]) {
                priorityQueue.add(taskWithIndex[i]);
                idx++;
            } else {
                break;
            }
        }

        int temp = 0;
        while (!priorityQueue.isEmpty()) {
            int[] currentTask = priorityQueue.poll();
            int curIdx = idx;
            for (int i = curIdx; i < n; i++) {
                if (taskWithIndex[i][0] <= currentTask[0] + currentTask[1]) {
                    priorityQueue.add(taskWithIndex[i]);
                    idx++;
                } else {
                    break;
                }
            }
            output[temp] = currentTask[2];
            temp++;
        }

        return output;
    }

    public static void main(String[] args) {
        int[] p1 = getOrder(new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}});
        System.out.println("p1 = " + ArrayUtils.Array1DToString(p1));

        int[] p2 = getOrder(new int[][]{{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}});
        System.out.println("p2 = " + ArrayUtils.Array1DToString(p2));
    }
}
