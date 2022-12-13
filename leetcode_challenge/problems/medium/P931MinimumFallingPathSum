package problems.medium;

public class P931MinimumFallingPathSum {
    public static int minFallingPathSum(int[][] matrix) {
        int[][] minSum = new int[matrix.length][matrix.length];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++)
            minSum[0][i] = matrix[0][i];
        minSum = traverse(matrix, 1, minSum);

        for (int i = 0; i < minSum.length; i++)
            min = Math.min(min, minSum[minSum.length - 1][i]);
        return min;
    }

    public static int[][] traverse(int[][] matrix, int row, int[][] minSum) {
        if (row == matrix.length)
            return minSum;

        for (int col = 0; col < matrix.length; col++) {
            if (col == 0)
                minSum[row][col] = Math.min(minSum[row - 1][col], minSum[row - 1][col + 1]) + matrix[row][col];
            else if (col == matrix.length - 1)
                minSum[row][col] = Math.min(minSum[row - 1][col], minSum[row - 1][col - 1]) + matrix[row][col];
            else
                minSum[row][col] = Math.min(Math.min(minSum[row - 1][col], minSum[row - 1][col - 1]), minSum[row - 1][col + 1]) + matrix[row][col];
        }
        return traverse(matrix, row + 1, minSum);
    }

    public static void main(String[] args) {
        int p1 = minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}});
        System.out.println("p1 = " + p1);

        int p2 = minFallingPathSum(new int[][]{{-19, 57}, {-40, -5}});
        System.out.println("p2 = " + p2);
    }
}
