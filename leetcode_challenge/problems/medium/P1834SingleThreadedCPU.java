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

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1])
                return a[2] - b[2];
            else
                return a[1] - b[1];
        });

        int startTime = taskWithIndex[0][0];
        int idx = 0;
        int temp = 0;
        while (temp <= n - 1) {
            int[] currentTask;
            if (priorityQueue.isEmpty()) {
                startTime = taskWithIndex[idx][0];
            } else {
                currentTask = priorityQueue.poll();
                startTime += currentTask[1];
                output[temp] = currentTask[2];
                temp++;
                System.out.println("currentTask = " + ArrayUtils.Array1DToString(currentTask));
            }

            int curIdx = idx;
            System.out.println("startTime = " + startTime);
            for (int i = curIdx; i < n; i++) {
                System.out.println("i = " + i);
                System.out.println("task traversed = " + ArrayUtils.Array1DToString(taskWithIndex[i]));
                if (taskWithIndex[i][0] <= startTime) {
                    System.out.println("task added");
                    priorityQueue.add(taskWithIndex[i]);
                    idx++;
                } else {
                    break;
                }
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int[] p1 = getOrder(new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}});
        System.out.println("p1 = " + ArrayUtils.Array1DToString(p1));

        int[] p2 = getOrder(new int[][]{{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}});
        System.out.println("p2 = " + ArrayUtils.Array1DToString(p2));

        int[] p3 = getOrder(new int[][]{{19, 13}, {16, 9}, {21, 10}, {32, 25}, {37, 4}, {49, 24}, {2, 15}, {38, 41}, {37, 34}, {33, 6}, {45, 4}, {18, 18}, {46, 39}, {12, 24}});
        System.out.println("p3 = " + ArrayUtils.Array1DToString(p3));

        int[] p4 = getOrder(new int[][]{{5, 2}, {7, 2}, {9, 4}, {6, 3}, {5, 10}, {1, 1}});
        System.out.println("p4 = " + ArrayUtils.Array1DToString(p4));

        int[] p5 = getOrder(new int[][]{{1, 2}, {10, 4}, {14, 2}, {14, 1}});
        System.out.println("p5 = " + ArrayUtils.Array1DToString(p5));
    }
}
