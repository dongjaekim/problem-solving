package problems.medium;

public class P74SearchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int targetRow = -1;
        for (int i = 0; i < m; i++) {
            if (matrix[i][n - 1] == target)
                return true;
            else if (matrix[i][n - 1] > target) {
                targetRow = i;
                break;
            }
        }

        if (targetRow == -1)
            return false;

        for (int j = 0; j < n; j++) {
            if (matrix[targetRow][j] == target)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        boolean p1 = searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3);
        System.out.println("p1 = " + p1);

        boolean p2 = searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13);
        System.out.println("p2 = " + p2);

        boolean p3 = searchMatrix(new int[][]{{1}}, 1);
        System.out.println("p3 = " + p3);
    }
}
