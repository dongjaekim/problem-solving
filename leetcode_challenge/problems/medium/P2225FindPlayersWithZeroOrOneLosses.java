package problems.medium;

import util.ArrayUtils;

import java.util.*;

public class P2225FindPlayersWithZeroOrOneLosses {
    public static List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < matches.length; i++) {
            if (!map.containsKey(matches[i][0]))
                map.put(matches[i][0], 0);

            if (map.containsKey(matches[i][1])) {
                Integer loseCnt = map.get(matches[i][1]);
                map.put(matches[i][1], loseCnt + 1);
            } else {
                map.put(matches[i][1], 1);
            }
        }

        List<Integer> winners = new ArrayList<>();
        List<Integer> losers = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0)
                winners.add(entry.getKey());
            else if (entry.getValue() == 1)
                losers.add(entry.getKey());
            else
                continue;
        }

        Collections.sort(winners);
        Collections.sort(losers);
        System.out.println("map = " + map);
        return new ArrayList<>(){{
            add(winners);
            add(losers);
        }};
    }

    public static void main(String[] args) {
//        String s = ArrayUtils.convertExampleAsValidForm("[[2,3],[1,3],[5,4],[6,4]]");
//        System.out.println("s = " + s);

        List<List<Integer>> p1 = findWinners(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}});
        System.out.println("p1 = " + p1);

        List<List<Integer>> p2 = findWinners(new int[][]{{2, 3}, {1, 3}, {5, 4}, {6, 4}});
        System.out.println("p2 = " + p2);
    }
}

