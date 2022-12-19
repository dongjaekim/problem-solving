package problems.medium;

import util.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P739DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] warmer = new int[temperatures.length];
        int hottest = 0;
//73, 74, 75, 71, 69, 72, 76, 73
        for(int i = temperatures.length - 1; i >= 0; i--) {
            if(temperatures[i] >= hottest) {
                warmer[i] = 0;
                hottest = temperatures[i];
            } else {
                // check neighbour
                int days = 1;
                while(temperatures[i + days] <= temperatures[i]) {
                    days += warmer[i + days];
                }
                warmer[i] = days;
            }
        }

        return warmer;
    }

    public static int[] dailyTemperatures2(int[] temperatures) {
        int[] output = new int[temperatures.length];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < temperatures.length - 1; i++) {
            int temperature = temperatures[i];
            if (map.containsKey(temperature) && map.get(temperature).get(1) > i) {
                output[i] = map.get(temperature).get(1) - (i - map.get(temperature).get(0));
                continue;
            }

            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperature < temperatures[j]) {
                    output[i] = j - i;
                    map.put(temperature, List.of(i, j - i));
                    break;
                }
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int[] p1 = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println("p1 = " + ArrayUtils.Array1DToString(p1));

        int[] p2 = dailyTemperatures(new int[]{30, 40, 50, 60});
        System.out.println("p2 = " + ArrayUtils.Array1DToString(p2));

        int[] p3 = dailyTemperatures(new int[]{30, 60, 90});
        System.out.println("p3 = " + ArrayUtils.Array1DToString(p3));

        int[] p4 = dailyTemperatures(new int[]{77, 41, 41, 41, 41, 77, 41, 77, 77, 77});
        System.out.println("p4 = " + ArrayUtils.Array1DToString(p4));
    }
}
