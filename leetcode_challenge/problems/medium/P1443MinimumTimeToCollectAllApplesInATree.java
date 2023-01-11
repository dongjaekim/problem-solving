package problems.medium;

import util.ArrayUtils;

import java.util.*;

public class P1443MinimumTimeToCollectAllApplesInATree {
    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, Set<Integer>> adjacentMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i++)
            adjacentMap.put(i, new HashSet<>());

        for (int i = 0; i < edges.length; i++) {
            adjacentMap.get(edges[i][0]).add(edges[i][1]);
            adjacentMap.get(edges[i][1]).add(edges[i][0]);
        }

        int minTime = dfs(0, visited, adjacentMap, hasApple);
        return minTime == 0 ? minTime : minTime - 2;
    }

    public static int dfs(int currentVertex, Set<Integer> visited, Map<Integer, Set<Integer>> adjacentMap, List<Boolean> hasApple) {
        int minTime = 0;
        if (visited.contains(currentVertex))
            return 0;
        visited.add(currentVertex);

        for (Integer adjacent : adjacentMap.get(currentVertex))
            minTime += dfs(adjacent, visited, adjacentMap, hasApple);

        if (minTime != 0)
            minTime += 2;

        if (hasApple.get(currentVertex))
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
    }
}
