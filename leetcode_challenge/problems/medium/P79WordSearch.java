package problems.medium;

public class P79WordSearch {
    public static boolean exist(char[][] board, String word) {
        char[] toCharArray = word.toCharArray();
        int rowSize = board.length;
        int colSize = board[0].length;
        boolean[][] visited = new boolean[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (board[i][j] == toCharArray[0]) {
                    visited[i][j] = true;
                    System.out.println("character: " + toCharArray[0] + ", idx: 0");
                    if (dfs(board, toCharArray, visited, new int[]{i, j}, 1))
                        return true;
                    visited[i][j] = false;
                }
            }
        }

        return false;
    }

    public static boolean dfs(char[][] board, char[] word, boolean[][] visited, int[] position, int idx) {
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        System.out.println("idx = " + idx);
        System.out.println("start position: " + position[0] + ", " + position[1]);
        if (idx == word.length)
            return true;

        for (int i = 0; i < direction.length; i++) {
            int newRow = position[0] + direction[i][0];
            int newCol = position[1] + direction[i][1];

            if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length)
                continue;
            System.out.println("character: " + board[newRow][newCol] + ", to be matched: " + word[idx]);
            if (visited[newRow][newCol]) {
                System.out.println("visited");
                continue;
            }

            if (board[newRow][newCol] == word[idx]) {
                visited[newRow][newCol] = true;
                System.out.println("character matched");
                if (dfs(board, word, visited, new int[]{newRow, newCol}, idx + 1))
                    return true;
                visited[newRow][newCol] = false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s = convertExampleAsValidForm("[[\"C\",\"A\",\"A\"],[\"A\",\"A\",\"A\"],[\"B\",\"C\",\"D\"]]");
        System.out.println("s = " + s);

//        boolean p1 = exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED");
//        System.out.println("p1 = " + p1);
//
//        boolean p2 = exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE");
//        System.out.println("p2 = " + p2);
//
//        boolean p3 = exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB");
//        System.out.println("p3 = " + p3);

        boolean p4 = exist(new char[][]{{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}}, "AAB");
        System.out.println("p4 = " + p4);
    }

    public static String convertExampleAsValidForm(String s) {
        return s.replaceAll("\\[", "{")
                .replaceAll("\\]", "}")
                .replaceAll("\"", "'");
    }
}
