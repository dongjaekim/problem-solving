package problems.medium;

import java.util.Arrays;

public class P947MostStonesRemovedWithSameRowOrColumn {
    public static int islandCount;
    public static int[] disjoint;

    public static int removeStones(int[][] stones) {
        if (stones.length == 1)
            return 0;

//        islandCount = stones.length;
//        disjoint = new int[stones.length];
        islandCount = 0;
        disjoint = new int[20001];

        /*for (int i = 0; i < disjoint.length; i++)
            disjoint[i] = i;

        for (int i = 0; i < stones.length - 1; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])
                    union(i, j);
            }
        }*/
        for (int i = 0; i < stones.length; i++)
            union(stones[i][0], stones[i][1] + 10000);

        return stones.length - islandCount;
    }

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        System.out.println("rootX = " + rootX);
        System.out.println("rootY = " + rootY);
        if (rootX != rootY) {
            disjoint[rootX] = rootY;
            islandCount--;
            System.out.println("islandCount decreased = " + islandCount);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                sb.append(disjoint[i]);
                if(i != 3)
                    sb.append(", ");
            }
            sb.append(" // ");
            for (int i = 10000; i < 10004; i++) {
                sb.append(disjoint[i]);
                if(i != 10003)
                    sb.append(", ");
            }
            System.out.println("sb = " + sb);
        }
    }

    public static int find(int x) {
        if (disjoint[x] == 0) {
            islandCount++;
            disjoint[x] = x;
            System.out.println("islandCount increased = " + islandCount);
        }
        if (disjoint[x] != x)
            disjoint[x] = find(disjoint[x]);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            sb.append(disjoint[i]);
            if(i != 3)
                sb.append(", ");
        }
        sb.append(" // ");
        for (int i = 10000; i < 10004; i++) {
            sb.append(disjoint[i]);
            if(i != 10003)
            sb.append(", ");
        }

        System.out.println("sb = " + sb);
        return disjoint[x];
    }

    public static void main(String[] args) {
        /*int p1 = removeStones(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}});
        System.out.println("p1 = " + p1);

        int p2 = removeStones(new int[][]{{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}});
        System.out.println("p2 = " + p2);

        int p3 = removeStones(new int[][]{{0, 0}});
        System.out.println("p3 = " + p3);*/

        int p4 = removeStones(new int[][]{{3, 2}, {0, 0}, {3, 3}, {2, 1}, {2, 3}, {2, 2}, {0, 2}});
        System.out.println("p4 = " + p4);
    }

    public static void arrayCopyTest(int[][] stones) {
        int[][] stones_copy = Arrays.copyOf(stones, stones.length - 1);
        for (int[] stone : stones_copy) {
            System.out.println("[" + stone[0] + ", " + stone[1] + "]");
        }
    }
}
