package problems.medium;

import java.util.HashMap;
import java.util.Map;

public class P36ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.')
                    continue;
                else {
                    String rowKey = "row" + j;
                    String columnKey = "column" + i;
                    String boxKey = "box" + (j / 3) + (i / 3) * 3;

                    if (map.containsKey(rowKey)) {
                        if (map.get(rowKey).contains(String.valueOf(board[i][j])))
                            return false;
                        else
                            map.put(rowKey, map.get(rowKey) + board[i][j]);
                    } else
                        map.put(rowKey, String.valueOf(board[i][j]));

                    if (map.containsKey(columnKey)) {
                        if (map.get(columnKey).contains(String.valueOf(board[i][j])))
                            return false;
                        else
                            map.put(columnKey, map.get(columnKey) + board[i][j]);
                    } else
                        map.put(columnKey, String.valueOf(board[i][j]));

                    if (map.containsKey(boxKey)) {
                        if (map.get(boxKey).contains(String.valueOf(board[i][j])))
                            return false;
                        else
                            map.put(boxKey, map.get(boxKey) + board[i][j]);
                    } else
                        map.put(boxKey, String.valueOf(board[i][j]));
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        boolean p1 = isValidSudoku(new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}});
        System.out.println("p1 = " + p1);

        boolean p2 = isValidSudoku(new char[][]{{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}});
        System.out.println("p2 = " + p2);
    }

    public static String convertExampleAsValidForm(String s) {
        return s.replaceAll("\\[", "{")
                .replaceAll("\\]", "}")
                .replaceAll("\"", "'");
    }
}
