package problems.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortestDistance {

    final int[][] direction = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    int answer = 10000;

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        // dfs(maps, new boolean[n][m], 0, 0, 0);
        // return answer == 10000 ? -1 : answer;

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, 0, 1 });

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int x = position[1];
            int y = position[0];
            int distance = position[2];

            if (maps[y][x] == 0 || visited[y][x]) {
                continue;
            }

            if (x == maps[0].length - 1 && y == maps.length - 1) {
                answer = distance;
                break;
            }

            distance++;
            visited[y][x] = true;

            for (int i = 0; i < direction.length; i++) {
                if (x + direction[i][1] >= maps[0].length || x + direction[i][1] < 0) {
                    continue;
                }
                if (y + direction[i][0] >= maps.length || y + direction[i][0] < 0) {
                    continue;
                }

                queue.offer(new int[] { y + direction[i][0], x + direction[i][1], distance });
            }
        }

        return answer == 10000 ? -1 : answer;
    }

    public void dfs(int[][] maps, boolean[][] visited, int x, int y, int distance) {
        if (maps[y][x] == 0 || visited[y][x] || distance > answer) {
            return;
        }

        distance++;

        if (x == maps[0].length - 1 && y == maps.length - 1) {
            answer = Math.min(answer, distance);
            return;
        }

        for (int i = 0; i < direction.length; i++) {
            if (x + direction[i][1] >= maps[0].length || x + direction[i][1] < 0) {
                continue;
            }
            if (y + direction[i][0] >= maps.length || y + direction[i][0] < 0) {
                continue;
            }

            visited[y][x] = true;
            dfs(maps, visited, x + direction[i][1], y + direction[i][0], distance);
            visited[y][x] = false;
        }
    }

}
