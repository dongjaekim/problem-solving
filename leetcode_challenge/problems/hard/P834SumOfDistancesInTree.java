package problems.hard;

import util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class P834SumOfDistancesInTree {
    public static int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[][] distances = new int[n][n];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        System.out.println("graph = " + graph);

        for (int i = 0; i < n; i++) {
            dfs(distances, graph, i, i, 1);
        }
        System.out.println("distances = " + ArrayUtils.Array2DToString(distances));
        return null;
    }

    public static void dfs(int[][] distances, List<List<Integer>> graph, int current, int next, int depth) {
        System.out.println("current = " + current + " // next = " + next + " // depth = " + depth + " starts");
        System.out.println("distances = " + ArrayUtils.Array2DToString(distances));
        for (Integer adjVertex : graph.get(next)) {
            System.out.println("adjVertex = " + adjVertex);
            if (current != adjVertex && distances[current][adjVertex] == 0) {
                distances[current][adjVertex] = depth;
                distances[adjVertex][current] = depth;
                dfs(distances, graph, current, adjVertex, depth + 1);
            } else if (current != adjVertex) {
                System.out.println("adjVertex distances = " + ArrayUtils.Array1DToString(distances[adjVertex]));
                for (int i = 0; i < distances.length; i++) {
                    if (i != current && i != next)
                        distances[current][i] = distances[adjVertex][i] + 1;
                }
            }
        }
        System.out.println("current = " + current + " // next = " + next + " // depth = " + depth + " ends");
    }

    public static void main(String[] args) {
        int[] p1 = sumOfDistancesInTree(6, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}});
        System.out.println("p1 = " + ArrayUtils.Array1DToString(p1));

        int[] p2 = sumOfDistancesInTree(1, new int[][]{});
        System.out.println("p2 = " + ArrayUtils.Array1DToString(p2));

        int[] p3 = sumOfDistancesInTree(2, new int[][]{{1, 0}});
        System.out.println("p3 = " + ArrayUtils.Array1DToString(p3));
    }
}