package problems.medium;

import util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class P886PossibleBipartition {
    public static boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] dislike : dislikes) {
            graph.get(dislike[0] - 1).add(dislike[1] - 1);
            graph.get(dislike[1] - 1).add(dislike[0] - 1);
        }
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                if (!dfs(color, graph, i, 1))
                    return false;
            }
        }

        return true;
    }

    public static boolean dfs(int[] color, List<List<Integer>> graph, int current, int currentColor) {
        color[current] = currentColor;
        System.out.println("current = " + current);
        System.out.println("color = " + ArrayUtils.Array1DToString(color));
        for (Integer person : graph.get(current)) {
            System.out.println("next = " + person);
            if (color[person] == 0) {
                if (!dfs(color, graph, person, -currentColor))
                    return false;
            } else if (color[person] == color[current])
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        boolean p1 = possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}});
        System.out.println("p1 = " + p1);

//        boolean p2 = possibleBipartition(3, new int[][]{{1, 2}, {1, 3}, {2, 3}});
//        System.out.println("p2 = " + p2);
//
//        boolean p3 = possibleBipartition(5, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}});
//        System.out.println("p3 = " + p3);
//
//        boolean p4 = possibleBipartition(5, new int[][]{{1, 2}, {3, 4}, {4, 5}, {3, 5}});
//        System.out.println("p4 = " + p4);
    }
}
