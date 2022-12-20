package problems.medium;

import java.util.List;
import java.util.Stack;

public class P841KeysAndRooms {
    public static boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[rooms.size()];

        stack.push(0);
        visited[0] = true;

        while (!stack.isEmpty()) {
            Integer currentRoom = stack.pop();
            List<Integer> keys = rooms.get(currentRoom);

            for (Integer key : keys) {
                if (!visited[key]) {
                    visited[key] = true;
                    stack.push(key);
                }
            }
        }

        boolean output = true;
        for (boolean b : visited)
            output = output && b;
        return output;
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        return rooms.size() == dfs(rooms, visited, 0, 0);
    }

    public static int dfs(List<List<Integer>> rooms, boolean[] visited, int curRoom, int count) {
        if (visited[curRoom])
            return count;

        visited[curRoom] = true;
        count++;

        for (Integer key : rooms.get(curRoom))
            count = dfs(rooms, visited, key, count);
        return count;
    }

    public static void main(String[] args) {
        boolean p1 = canVisitAllRooms(List.of(List.of(1), List.of(2), List.of(3), List.of()));
        System.out.println("p1 = " + p1);

        boolean p2 = canVisitAllRooms(List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0)));
        System.out.println("p2 = " + p2);
    }
}
