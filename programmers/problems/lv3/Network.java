package problems.lv3;

import java.util.HashSet;

public class Network {
    public int solution(int n, int[][] computers) {
        int[] group = new int[n];

        for (int i = 0; i < n; i++)
            group[i] = i;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    int groupI = find(i, group);
                    int groupJ = find(j, group);
                    if (groupI > groupJ)
                        group[groupI] = groupJ;
                    else
                        group[groupJ] = groupI;
                }
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i : group)
            set.add(find(i, group));

        return set.size();
    }

    public int find(int num, int[] group) {
        if (group[num] == num)
            return num;

        group[num] = find(group[num], group);
        return group[num];
    }
}
