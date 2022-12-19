package problems.easy;

import java.util.*;

public class P1971FindIfPathExistsInGraph {
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        int maxEdge = n * (n - 1) / 2;
        if (edges.length == maxEdge)
            return true;

        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(source);

        while (!stack.isEmpty()) {
            Integer vertex = stack.pop();
            visited[vertex] = true;

            for (int i = 0; i < edges.length; i++) {
                if (vertex == edges[i][0] && !visited[edges[i][1]]) {
                    if (edges[i][1] == destination)
                        return true;
                    stack.push(edges[i][1]);
                } else if (vertex == edges[i][1] && !visited[edges[i][0]]) {
                    if (edges[i][0] == destination)
                        return true;
                    stack.push(edges[i][0]);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        boolean p1 = validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2);
        System.out.println("p1 = " + p1);

        boolean p2 = validPath(6, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5);
        System.out.println("p2 = " + p2);

        boolean p3 = validPath(6, new int[][]{{0, 1}, {0, 2}, {1, 3}, {3, 5}, {5, 4}, {4, 3}}, 0, 5);
        System.out.println("p3 = " + p3);

        boolean p4 = validPath(10, new int[][]{{0, 7}, {0, 8}, {6, 1}, {2, 0}, {0, 4}, {5, 8}, {4, 7}, {1, 3}, {3, 5}, {6, 5}}, 7, 5);
        System.out.println("p4 = " + p4);
    }
}
