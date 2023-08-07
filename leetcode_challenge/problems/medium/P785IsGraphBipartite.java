package problems.medium;

import java.util.*;

public class P785IsGraphBipartite {
    
    public static boolean isBipartite(int[][] graph) {
        Map<Integer, Integer> color = new HashMap<>();

        for (int i = 0; i < graph.length; i++) {
            if (!color.containsKey(i)) {
                if (!bfs(graph, color, i))
                    return false;
                else if (color.size() == graph.length)
                    return true;
            }
        }

        return true;
    }

    public static boolean bfs(int[][] graph, Map<Integer, Integer> color, int node) {
        Queue<Integer> nodesToVisit = new LinkedList<>();
        nodesToVisit.add(node);
        color.put(node, 1);

        while (nodesToVisit.size() > 0) {
            Integer visited = nodesToVisit.poll();

            for (int adjacent : graph[visited]) {
                if (color.containsKey(adjacent)) {
                    if (color.get(adjacent) == color.get(visited))
                        return false;
                } else {
                    color.put(adjacent, -color.get(visited));
                    nodesToVisit.add(adjacent);
                }
            }
        }

        return true;
    }
    
    public static void main(String[] args) {
        boolean e1 = isBipartite(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}); // false
        System.out.println("e1 = " + e1);

        boolean e2 = isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}); // true
        System.out.println("e2 = " + e2);

        boolean e3 = isBipartite(new int[][]{{1}, {0, 3}, {3}, {1, 2}}); // true
        System.out.println("e3 = " + e3);

        boolean e4 = isBipartite(new int[][]{{}, {2, 4, 6}, {1, 4, 8, 9}, {7, 8}, {1, 2, 8, 9}, {6, 9}, {1, 5, 7, 8, 9}, {3, 6, 9}, {2, 3, 4, 6, 9}, {2, 4, 5, 6, 7, 8}}); // false
        System.out.println("e4 = " + e4);
    }
}
