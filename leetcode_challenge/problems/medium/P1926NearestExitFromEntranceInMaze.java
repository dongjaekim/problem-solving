package problems.medium;

import util.ArrayUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

public class P1926NearestExitFromEntranceInMaze {
    static boolean[][] visited;

    public static int nearestExit(char[][] maze, int[] entrance) {
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        visited = new boolean[maze.length][maze[0].length];
        visited[entrance[0]][entrance[1]] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0});
        while (!queue.isEmpty()) {
            int[] currentPosition = queue.poll();
            for (int[] direction : directions) {
                int newRow = currentPosition[0] + direction[0];
                int newColumn = currentPosition[1] + direction[1];

                if (newRow >= 0 && newRow < maze.length && newColumn >= 0 && newColumn < maze[0].length
                        && !visited[newRow][newColumn] && maze[newRow][newColumn] == '.') {
                    visited[newRow][newColumn] = true;
                    if (newRow == 0 || newRow == maze.length - 1 || newColumn == 0 || newColumn == maze[0].length - 1)
                        return currentPosition[2] + 1;
                    queue.offer(new int[]{newRow, newColumn, currentPosition[2] + 1});
                }
            }
        }

        return -1;
    }

    public static int dfs(char[][] maze, boolean[][] visited, int[] entrance, int[] currentPosition, int step) {
        int goLeft = 10000;
        int goRight = 10000;
        int goUp = 10000;
        int goDown = 10000;

        System.out.println("currentPosition = " + ArrayUtils.Array1DToString(currentPosition));
        System.out.println("step = " + step);
        if (currentPosition[0] == 0 || currentPosition[0] == maze.length - 1 || currentPosition[1] == 0 || currentPosition[1] == maze[0].length - 1) {
            if (entrance[0] != currentPosition[0] || entrance[1] != currentPosition[1]) {
                System.out.println("step from condition = " + step);
                return step;
            }
        } else
            visited[currentPosition[0]][currentPosition[1]] = true;

        if (currentPosition[0] > 0 && maze[currentPosition[0] - 1][currentPosition[1]] == '.' && !visited[currentPosition[0] - 1][currentPosition[1]])
            goDown = dfs(maze, visited, entrance, new int[]{currentPosition[0] - 1, currentPosition[1]}, step + 1);
        if (currentPosition[0] < maze.length - 1 && maze[currentPosition[0] + 1][currentPosition[1]] == '.' && !visited[currentPosition[0] + 1][currentPosition[1]])
            goUp = dfs(maze, visited, entrance, new int[]{currentPosition[0] + 1, currentPosition[1]}, step + 1);
        if (currentPosition[1] < maze[0].length - 1 && maze[currentPosition[0]][currentPosition[1] + 1] == '.' && !visited[currentPosition[0]][currentPosition[1] + 1])
            goRight = dfs(maze, visited, entrance, new int[]{currentPosition[0], currentPosition[1] + 1}, step + 1);
        if (currentPosition[1] > 0 && maze[currentPosition[0]][currentPosition[1] - 1] == '.' && !visited[currentPosition[0]][currentPosition[1] - 1])
            goLeft = dfs(maze, visited, entrance, new int[]{currentPosition[0], currentPosition[1] - 1}, step + 1);

        return Math.min(Math.min(Math.min(goLeft, goRight), goUp), goDown);
    }

    public static void main(String[] args) {
        int p1 = nearestExit(new char[][]{{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}}, new int[]{1, 2});
        System.out.println("p1 = " + p1);

        int p2 = nearestExit(new char[][]{{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}}, new int[]{1, 0});
        System.out.println("p2 = " + p2);

        int p3 = nearestExit(new char[][]{{'.', '+'}}, new int[]{0, 0});
        System.out.println("p3 = " + p3);

        int p4 = nearestExit(new char[][]{{'+'}, {'.'}}, new int[]{1, 0});
        System.out.println("p4 = " + p4);

        int p5 = nearestExit(new char[][]{{'+', '.', '+', '+', '+', '+', '+'}, {'+', '.', '+', '.', '.', '.', '+'}, {'+', '.', '+', '.', '+', '.', '+'}, {'+', '.', '.', '.', '.', '.', '+'}, {'+', '+', '+', '+', '.', '+', '.'}}, new int[]{0, 1});
        System.out.println("p5 = " + p5);

        int p6 = nearestExit(new char[][]{{'.', '.', '.', '.', '.', '+', '.', '.', '.'}, {'.', '+', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '+', '.', '+', '.', '+', '.', '+'}, {'.', '.', '.', '.', '+', '.', '.', '.', '.'}, {'.', '.', '.', '.', '+', '+', '.', '.', '.'}, {'+', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '+', '.', '.', '.', '.', '.'}, {'.', '.', '.', '+', '.', '.', '.', '.', '+'}, {'+', '.', '.', '+', '.', '+', '+', '.', '.'}}, new int[]{8, 4});
        System.out.println("p6 = " + p6);

        int p7 = nearestExit(new char[][]{{'+', '.', '+', '+', '+', '+', '+'}, {'+', '.', '+', '.', '.', '.', '+'}, {'+', '.', '+', '.', '+', '.', '+'}, {'+', '.', '.', '.', '+', '.', '+'}, {'+', '+', '+', '+', '+', '+', '.'}}, new int[]{0, 1});
        System.out.println("p7 = " + p7);
    }
}
