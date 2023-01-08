package problems.hard;

import util.ArrayUtils;

import java.util.*;

public class P149MaxPointsOnALine {
    public static int maxPoints(int[][] points) {
        int n = points.length;
        HashMap<String, Set<String>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] p1 = points[i];
                int[] p2 = points[j];

                float a = p1[0] - p2[0] == 0 ? 0 : (float) (p1[1] - p2[1]) / (p1[0] - p2[0]);
                float b = (float) p1[1] - a * p1[0];

                String key = "";
                if (a != 0)
                    key = a + "_" + b;
                else if (a == 0 && p1[0] == p2[0])
                    key = "x = " + p1[0];
                else if (a == 0 && p1[1] == p2[1])
                    key = "y = " + p1[1];

                Set<String> values = map.getOrDefault(key, new HashSet<>());
                values.add(p1[0] + "_" + p1[1]);
                values.add(p2[0] + "_" + p2[1]);
                map.put(key, values);
            }
        }

        int max = 1;
        for (Set<String> value : map.values())
            max = Math.max(max, value.size());

        return max;
    }

    public static void main(String[] args) {
//        int p1 = maxPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}});
//        System.out.println("p1 = " + p1);
//
//        int p2 = maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}});
//        System.out.println("p2 = " + p2);
//
//        int p3 = maxPoints(new int[][]{{4, 5}, {4, -1}, {4, 0}});
//        System.out.println("p3 = " + p3);
//
//        int p4 = maxPoints(new int[][]{{-6, -1}, {3, 1}, {12, 3}});
//        System.out.println("p4 = " + p4);

        int p5 = maxPoints(new int[][]{{7, 3}, {19, 19}, {-16, 3}, {13, 17}, {-18, 1}, {-18, -17}, {13, -3}, {3, 7}, {-11, 12}, {7, 19}, {19, -12}, {20, -18}, {-16, -15}, {-10, -15}, {-16, -18}, {-14, -1}, {18, 10}, {-13, 8}, {7, -5}, {-4, -9}, {-11, 2}, {-9, -9}, {-5, -16}, {10, 14}, {-3, 4}, {1, -20}, {2, 16}, {0, 14}, {-14, 5}, {15, -11}, {3, 11}, {11, -10}, {-1, -7}, {16, 7}, {1, -11}, {-8, -3}, {1, -6}, {19, 7}, {3, 6}, {-1, -2}, {7, -3}, {-6, -8}, {7, 1}, {-15, 12}, {-17, 9}, {19, -9}, {1, 0}, {9, -10}, {6, 20}, {-12, -4}, {-16, -17}, {14, 3}, {0, -1}, {-18, 9}, {-15, 15}, {-3, -15}, {-5, 20}, {15, -14}, {9, -17}, {10, -14}, {-7, -11}, {14, 9}, {1, -1}, {15, 12}, {-5, -1}, {-17, -5}, {15, -2}, {-12, 11}, {19, -18}, {8, 7}, {-5, -3}, {-17, -1}, {-18, 13}, {15, -3}, {4, 18}, {-14, -15}, {15, 8}, {-18, -12}, {-15, 19}, {-9, 16}, {-9, 14}, {-12, -14}, {-2, -20}, {-3, -13}, {10, -7}, {-2, -10}, {9, 10}, {-1, 7}, {-17, -6}, {-15, 20}, {5, -17}, {6, -6}, {-11, -8}});
        System.out.println("p5 = " + p5);

//        int p6 = maxPoints(new int[][]{{54, 153}, {1, 3}, {0, -72}, {-3, 3}, {12, -22}, {-60, -322}, {0, -5}, {-5, 1}, {5, 5}, {36, 78}, {3, -4}, {5, 0}, {0, 4}, {-30, -197}, {-5, 0}, {60, 178}, {0, 0}, {30, 53}, {24, 28}, {4, 5}, {2, -2}, {-18, -147}, {-24, -172}, {-36, -222}, {-42, -247}, {2, 3}, {-12, -122}, {-54, -297}, {6, -47}, {-5, 3}, {-48, -272}, {-4, -2}, {3, -2}, {0, 2}, {48, 128}, {4, 3}, {2, 4}});
//        System.out.println("p6 = " + p6);
    }
}
