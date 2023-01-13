package problems.medium;

import util.ArrayUtils;

import java.util.*;

public class P1519NumberOfNodesInTheSubTreeWithTheSameLabel {
    static int[] output;

    public static int[] countSubTrees(int n, int[][] edges, String labels) {
        output = new int[n];
        boolean[] visited = new boolean[n];
        Map<Character, Integer> labelMap = new HashMap<>();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        labelMap = dfs(0, visited, graph, labels, labelMap);

        return output;
    }

    public static Map<Character, Integer> dfs(int currentNode, boolean[] visited, List<List<Integer>> graph, String labels, Map<Character, Integer> labelMap) {
        Map<Character, Integer> currentLabelMap = new HashMap<>();

        if (visited[currentNode])
            return labelMap;
        visited[currentNode] = true;

        for (Integer nextNode : graph.get(currentNode)) {
            Map<Character, Integer> mapOfChildNode = dfs(nextNode, visited, graph, labels, labelMap);
            for (Map.Entry<Character, Integer> entry : mapOfChildNode.entrySet())
                currentLabelMap.put(entry.getKey(), currentLabelMap.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }

        char label = labels.charAt(currentNode);
        if (currentLabelMap.containsKey(label))
            output[currentNode] = currentLabelMap.get(label) + 1;
        else
            output[currentNode] = 1;
        currentLabelMap.put(label, output[currentNode]);

        return currentLabelMap;
    }

    public static void main(String[] args) {
        int[] p1 = countSubTrees(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, "abaedcd");
        System.out.println("p1 = " + ArrayUtils.Array1DToString(p1));

        int[] p2 = countSubTrees(4, new int[][]{{0, 1}, {1, 2}, {0, 3}}, "bbbb");
        System.out.println("p2 = " + ArrayUtils.Array1DToString(p2));

        int[] p3 = countSubTrees(5, new int[][]{{0, 1}, {0, 2}, {1, 3}, {0, 4}}, "aabab");
        System.out.println("p3 = " + ArrayUtils.Array1DToString(p3));
    }
}
