package problems.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class ForkLiftAndCrane {
    boolean[][] removed;
    char[][] storageCharAry;

    public static void main(String[] args) {
        ForkLiftAndCrane fork = new ForkLiftAndCrane();
        int e1 = fork.solution(new String[] { "AZWQY", "CAABX", "BBDDA", "ACACA" }, new String[] { "A", "BB", "A" });
        System.out.println("e1 = " + e1);

        ForkLiftAndCrane fork2 = new ForkLiftAndCrane();
        int e2 = fork2.solution(new String[] { "HAH", "HBH", "HHH", "HAH", "HBH" }, new String[] { "C", "B", "B", "B", "B", "H" });
        System.out.println("e2 = " + e2);
    }

    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();
        removed = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            storageCharAry[i] = storage[i].toCharArray();
        }

        for (String request : requests) {
            if (request.length() == 1) {
                forkLift(storage, n, m, request);
            } else {
                crane(storage, n, m, request);
            }
        }

        print(n, m);

        return count(n, m);
    }

    private void print(int n, int m) {
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(removed[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("]");
    }

    private int count(int n, int m) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!removed[i][j])
                    count++;
            }
        }

        return count;
    }

    private void forkLift(String[] storage, int n, int m, String container) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    if (removed[i][j]) {
                        queue.offer(new int[]{i, j});
                    } else if (storage[i].charAt(j) == container.charAt(0)) {
                        removed[i][j] = true;
                        visited[i][j] = true;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            if (position[0] > 0) {
                if (removed[position[0] - 1][position[1]] && !visited[position[0] - 1][position[1]]) {
                    queue.offer(new int[]{position[0] - 1, position[1]});
                    visited[position[0] - 1][position[1]] = true;
                } else if (storage[position[0] - 1].charAt(position[1]) == container.charAt(0)) {
                    removed[position[0] - 1][position[1]] = true;
                    visited[position[0] - 1][position[1]] = true;
                }
            }

            if (position[1] > 0) {
                if (removed[position[0]][position[1] - 1] && !visited[position[0]][position[1] - 1]) {
                    queue.offer(new int[]{position[0], position[1] - 1});
                    visited[position[0]][position[1] - 1] = true;
                } else if (storage[position[0]].charAt(position[1] - 1) == container.charAt(0)) {
                    removed[position[0]][position[1] - 1] = true;
                    visited[position[0]][position[1] - 1] = true;
                }
            }

            if (position[0] < n - 1) {
                if (removed[position[0] + 1][position[1]] && !visited[position[0] + 1][position[1]]) {
                    queue.offer(new int[]{position[0] + 1, position[1]});
                    visited[position[0] + 1][position[1]] = true;
                } else if (storage[position[0] + 1].charAt(position[1]) == container.charAt(0)) {
                    removed[position[0] + 1][position[1]] = true;
                    visited[position[0] + 1][position[1]] = true;
                }
            }

            if (position[1] < m - 1) {
                if (removed[position[0]][position[1] + 1] && !visited[position[0]][position[1] + 1]) {
                    queue.offer(new int[]{position[0], position[1] + 1});
                    visited[position[0]][position[1] + 1] = true;
                } else if (storage[position[0]].charAt(position[1] + 1) == container.charAt(0)) {
                    removed[position[0]][position[1] + 1] = true;
                    visited[position[0]][position[1] + 1] = true;
                }
            }
        }
    }

    private void crane(String[] storage, int n, int m, String container) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (storage[i].charAt(j) == container.charAt(0))
                    removed[i][j] = true;
            }
        }
    }
}
