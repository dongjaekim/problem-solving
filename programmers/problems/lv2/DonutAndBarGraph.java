package problems.lv2;

import java.util.*;
import java.util.stream.Collectors;

class DonutAndBarGraph {
    public static void main(String[] args) {
        int[] ints = solution(new int[][] {{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}});
        print(ints);
    }

    public static void print(int[] arr) {
        System.out.print("[");
        String collect = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(collect + "]");
    }
  
    public static int[] solution(int[][] edges) {
        int[] answer = new int[4];

        Map<Integer, List<Integer>> inMap = new HashMap<>();
        Map<Integer, List<Integer>> outMap = new HashMap<>();
        Set<Integer> vertexSet = new HashSet<>();

        Arrays.stream(edges).forEach(e -> {
            outMap.computeIfAbsent(e[0], k -> new ArrayList<>());
            outMap.get(e[0]).add(e[1]);

            inMap.computeIfAbsent(e[1], k -> new ArrayList<>());
            inMap.get(e[1]).add(e[0]);

            vertexSet.add(e[0]);
            vertexSet.add(e[1]);
        });

        outMap.entrySet().stream()
            .filter(e -> e.getValue().size() >= 2)
            .forEach(e -> {
                if (inMap.get(e.getKey()) == null)
                    answer[0] = e.getKey();
            });

        for (Integer i : vertexSet) {
            if (i == answer[0])
                continue;
            if (outMap.get(i) == null)
                answer[2]++;
            else if(outMap.get(i).size() == 2)
                answer[3]++;
        }
        answer[1] = outMap.get(answer[0]).size() - answer[2] - answer[3];

        return answer;
    }
}
