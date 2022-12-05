package problems.hard;

import java.util.HashMap;

public class P765CouplesHoldingHands {
    public static int minSwapsCouples(int[] row) {
        int output = 0;

        int[] position = new int[row.length];
        for (int i = 0; i < row.length; i++)
            position[row[i]] = i;

        for (int i = 0; i < row.length; i += 2) {
            int couple1 = row[i];
            int nextToCouple1 = row[i + 1];
            int couple2 = couple1 % 2 == 0 ? couple1 + 1 : couple1 - 1;

            if (nextToCouple1 != couple2) {
                int couple2Position = position[couple2];
                row[couple2Position] = nextToCouple1;
                row[i + 1] = couple2;
                position[couple2] = i + 1;
                position[nextToCouple1] = couple2Position;
                output++;
            }
        }

        return output;
    }

    public static int minSwapsCouples2(int[] row) {
        int output = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < row.length; i++)
            map.put(row[i], i);

        for (int i = 0; i < row.length; i = i + 2) {
            int couple1 = row[i];
            int nextToCouple1 = row[i + 1];
            int couple2;

            if (couple1 % 2 == 0)
                couple2 = couple1 + 1;
            else
                couple2 = couple1 - 1;

            if (nextToCouple1 != couple2) {
                int couple2Position = map.get(couple2);
                row[couple2Position] = nextToCouple1;
                row[i + 1] = couple2;
                map.put(couple2, i + 1);
                map.put(nextToCouple1, couple2Position);
                output++;
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int p1 = minSwapsCouples(new int[]{0, 2, 1, 3});
        System.out.println("p1 = " + p1);

        int p2 = minSwapsCouples(new int[]{3, 2, 0, 1});
        System.out.println("p2 = " + p2);

        int p3 = minSwapsCouples(new int[]{0, 2, 3, 4, 5, 1});
        System.out.println("p3 = " + p3);
    }
}
