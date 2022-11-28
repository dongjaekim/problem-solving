package problems.hard;

import java.util.*;

public class P1235MaximumProfitInJobScheduling {
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] job = new int[startTime.length][3];

        for (int i = 0; i < job.length; i++)
            job[i] = new int[]{endTime[i], startTime[i], profit[i]};

        Arrays.sort(job, (a1, a2) -> {
            if (a1[0] < a2[0])
                return -1;
            else if (a1[0] > a2[0])
                return 1;
            else
                return a1[1] - a2[1];
        });

        System.out.println("job = " + toString(job));
        int[] dp = new int[job.length];
        dp[0] = job[0][2];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], job[i][2]);
            for (int j = i - 1; j >= 0; j--) {
                if (job[j][0] <= job[i][1])
                    dp[i] = Math.max(dp[i], dp[j] + job[i][2]);
            }
        }

        return dp[dp.length - 1];
    }

    public static int jobScheduling2(int[] startTime, int[] endTime, int[] profit) {
        int inputSize = startTime.length;

        int[][] job = new int[startTime.length][3];
        for (int i = 0; i < job.length; i++)
            job[i] = new int[]{endTime[i], startTime[i], profit[i]};

        Arrays.sort(job, (a1, a2) -> {
            if (a1[0] < a2[0])
                return -1;
            else if (a1[0] > a2[0])
                return 1;
            else
                return a1[1] - a2[1];
        });

        System.out.println("job = " + toString(job));

        TreeMap<Integer, Integer> map = new TreeMap<>(){{
            put(0, 0);
        }};

        for (int[] jobInfo : job) {
            int curProfit = jobInfo[2] + map.floorEntry(jobInfo[1]).getValue();
            if (curProfit > map.lastEntry().getValue())
                map.put(jobInfo[0], curProfit);
        }

        return map.lastEntry().getValue();
    }

    public static void main(String[] args) {
        int p1 = jobScheduling(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70});
        System.out.println("p1 = " + p1);

        int p2 = jobScheduling(new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60});
        System.out.println("p2 = " + p2);

        int p3 = jobScheduling(new int[]{1, 1, 1,}, new int[]{2, 3, 4}, new int[]{5, 6, 4});
        System.out.println("p3 = " + p3);

        int p4 = jobScheduling(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 1000000000}, new int[]{50, 10, 40, 70});
        System.out.println("p4 = " + p4);
    }

    public static String toString(int[][] ary) {
        StringBuilder sb = new StringBuilder();
        StringJoiner sj = new StringJoiner(", ");
        sb.append("[");
        for (int i = 0; i < ary.length; i++)
            sj.add("[" + ary[i][0] + ", " + ary[i][1] + ", " + ary[i][2] + "]");
        sb.append(sj);
        sb.append("]");
        return sb.toString();
    }
}
