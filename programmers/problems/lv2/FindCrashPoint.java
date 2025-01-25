package problems.lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class FindCrashPoint {
    public int solution(int[][] points, int[][] routes) {
        Map<Integer, List<Point>> routeMap = new HashMap<>();
        int answer = 0;

        int maxLen = 0;
        for (int i = 0; i < routes.length; i++) {
            List<Point> route = new ArrayList<>();

            for (int j = 0; j < routes[i].length - 1; j++) {
                int[] start = new int[2];
                int[] dest = new int[2];
                start[0] = points[routes[i][j] - 1][0];
                start[1] = points[routes[i][j] - 1][1];
                dest[0] = points[routes[i][j + 1] - 1][0];
                dest[1] = points[routes[i][j + 1] - 1][1];

                if (route.isEmpty()) {
                    route.add(new Point(start[0], start[1]));
                }

                while (start[0] != dest[0] || start[1] != dest[1]) {
                    if (start[0] > dest[0]) {
                        start[0]--;
                        route.add(new Point(start[0], start[1]));
                        continue;
                    } else if (start[0] < dest[0]) {
                        start[0]++;
                        route.add(new Point(start[0], start[1]));
                        continue;
                    }

                    if (start[1] > dest[1]) {
                        start[1]--;
                        route.add(new Point(start[0], start[1]));
                        continue;
                    } else if (start[1] < dest[1]) {
                        start[1]++;
                        route.add(new Point(start[0], start[1]));
                        continue;
                    }
                }
            }
            if (maxLen < route.size())
                maxLen = route.size();
            routeMap.put(i, route);
        }

        for (int i = 0; i < maxLen; i++) {
            Map<Point, Integer> freqMap = new HashMap<>();
            for (List<Point> route : routeMap.values()) {
                if (route.size() - 1 < i)
                    continue;
                freqMap.put(route.get(i), freqMap.getOrDefault(route.get(i), 0) + 1);
            }

            answer += freqMap.values().stream().filter(c -> c > 1).collect(Collectors.toList()).size();
        }

        return answer;
    }

    static class Point {
        private int row;
        private int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object obj) {
            Point point = (Point) obj;
            return this.row == point.getRow() && this.col == point.getCol();
        }

        @Override
        public String toString() {
            return "(" + this.row + ", " + this.col + ")";
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.row, this.col);
        }

        public int getRow() {
            return this.row;
        }

        public int getCol() {
            return this.col;
        }
    }
}
