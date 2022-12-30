package problems.medium;

import java.util.ArrayList;
import java.util.List;

public class P797AllPathsFromSourceToTarget {
    static List<List<Integer>> paths = new ArrayList<>();

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int target = graph.length - 1;
        dfs(new ArrayList<>(), graph, 0, target);
        return paths;
    }

    public static void dfs(List<Integer> currentPath, int[][] graph, int currentNode, int target) {
        List<Integer> path = new ArrayList<>(currentPath);
        path.add(currentNode);
        if (currentNode == target) {
            paths.add(path);
            return;
        }

        int[] adjacentNodes = graph[currentNode];
        for (int adjacentNode : adjacentNodes)
            dfs(path, graph, adjacentNode, target);
    }

    public static void main(String[] args) {
        List<List<Integer>> p1 = allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}});
        System.out.println("p1 = " + p1);

        List<List<Integer>> p2 = allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}});
        System.out.println("p2 = " + p2);
    }
}
