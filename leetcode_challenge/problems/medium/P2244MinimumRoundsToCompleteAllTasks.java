package problems.medium;

import java.util.HashMap;

public class P2244MinimumRoundsToCompleteAllTasks {
    public static int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> taskMap = new HashMap<>();
        int output = 0;
        for (int task : tasks)
            taskMap.put(task, taskMap.getOrDefault(task, 0) + 1);

        for (Integer value : taskMap.values()) {
            if (value == 1)
                return -1;

            if (value % 3 == 0)
                output += value / 3;
            else
                output += value / 3 + 1;
        }

        return output;
    }

    public static void main(String[] args) {
        int p1 = minimumRounds(new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4});
        System.out.println("p1 = " + p1);

        int p2 = minimumRounds(new int[]{2, 3, 3});
        System.out.println("p2 = " + p2);
    }
}
