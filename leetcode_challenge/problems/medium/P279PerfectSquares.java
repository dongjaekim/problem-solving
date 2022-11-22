package problems.medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

public class P279PerfectSquares {
    public static int numSquares(int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{n, 1});

        boolean[] visited = new boolean[n + 1];
        visited[n] = true;

        int cnt = 1;
        while (!queue.isEmpty()) {
            int[] deQ = queue.poll();

            for (int i = 1; i < 100; i++) {
                int nextNum = deQ[0] - i * i;
                if (nextNum > 0 && visited[nextNum])
                    continue;

                System.out.println("nextNum = " + nextNum);
                if (nextNum > 0) {
                    visited[nextNum] = true;
                    queue.offer(new int[]{nextNum, deQ[1] + 1});
                } else if (nextNum == 0) {
                    System.out.println("return cnt = " + deQ[1]);
                    cnt = deQ[1];
                    return deQ[1];
                } else
                    break;
            }
        }

        return cnt;
    }

    public static String toString(int[] ary) {
        StringJoiner joiner = new StringJoiner(", ");
        for (int i : ary) {
            joiner.add(String.valueOf(i));
        }
        return "[" + joiner + "]";
    }

    public static void main(String[] args) {
        int p1 = numSquares(12);
        System.out.println("p1 = " + p1);
//
//        int p2 = numSquares(13);
//        System.out.println("p2 = " + p2);
//
//        int p3 = numSquares(285);
//        System.out.println("p3 = " + p3);
//
//        int p4 = numSquares(7158);
//        System.out.println("p4 = " + p4);
    }
}
