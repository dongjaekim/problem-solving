package problems.medium;

import util.ArrayUtils;

import java.util.*;

public class P1443MinimumTimeToCollectAllApplesInATree {
    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        int minTime = dfs(0, visited, graph, hasApple);
        return minTime == 0 ? minTime : minTime - 2;
    }

    public static int dfs(int currentVertex, boolean[] visited, List<List<Integer>> graph, List<Boolean> hasApple) {
        int minTime = 0;
        if (visited[currentVertex])
            return 0;
        visited[currentVertex] = true;

        for (Integer adjacent : graph.get(currentVertex))
            minTime += dfs(adjacent, visited, graph, hasApple);

        if (minTime != 0 || hasApple.get(currentVertex))
            minTime += 2;

        return minTime;
    }

    public static void main(String[] args) {
        int p1 = minTime(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, List.of(false, false, true, false, true, true, false));
        System.out.println("p1 = " + p1);

        int p2 = minTime(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, List.of(false, false, true, false, false, true, false));
        System.out.println("p2 = " + p2);

        int p3 = minTime(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, List.of(false, false, false, false, false, false, false));
        System.out.println("p3 = " + p3);

        int p4 = minTime(4, new int[][]{{0, 1}, {1, 2}, {0, 3}}, List.of(true, true, true, true));
        System.out.println("p4 = " + p4);
    }
}
