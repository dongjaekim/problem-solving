package problems.lv2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class OilDrill {
    List<Integer> oilCount;
    List<Set<Integer>> oilGroup;

    public static void main(String[] args) {
        OilDrill oilDrill = new OilDrill();
        int solution = oilDrill.solution(
                new int[][] { { 0, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 1, 1, 0, 0 }, { 1, 1, 0, 0, 0, 1, 1, 0 }, { 1, 1, 1, 0, 0, 0, 0, 0 },
                              { 1, 1, 1, 0, 0, 0, 1, 1 } });
        System.out.println("solution = " + solution);
    }

    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;

        oilCount = new ArrayList<>();
        oilGroup = new ArrayList<>();

        oilCount.add(0);
        oilCount.add(0);

        for (int i = 0; i < m; i++) {
            oilGroup.add(new HashSet<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1) {
                    oilCount.add(0);
                    bfs(land, new int[]{i, j});
                }
            }
        }

        int answer = 0;
        for (Set<Integer> group : oilGroup) {
            int totalOil = 0;
            for (int oil : group) {
                totalOil += oilCount.get(oil);
            }
            answer = Math.max(answer, totalOil);
        }

        return answer;
    }

    public void bfs(int[][] land, int[] position) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(position);

        int marker = oilCount.size() - 1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x < 0 || x >= land.length || y < 0 || y >= land[0].length || land[x][y] != 1) {
                continue;
            }

            land[x][y] = marker;

            oilCount.set(marker, oilCount.get(marker) + 1);

            oilGroup.get(y).add(marker);

            queue.offer(new int[]{x - 1, y});
            queue.offer(new int[]{x + 1, y});
            queue.offer(new int[]{x, y - 1});
            queue.offer(new int[]{x, y + 1});
        }
    }
}
