package problems.medium;

public class P59SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int i = 0;
        int j = 0;
        int[][] visited = new int[n][n];
        int[][] output = new int[n][n];
        int mode = 0;
        int num = 1;
        int max = n * n;

        while (num <= max) {
            visited[i][j] = 1;
            output[i][j] = num;
            num++;

            if (mode == 0) {
                if (j + 1 < n && visited[i][j + 1] == 0) {
                    j++;
                } else {
                    i++;
                    mode = 1;
                }
            } else if (mode == 1) {
                if (i + 1 < n && visited[i + 1][j] == 0) {
                    i++;
                } else {
                    j--;
                    mode = 2;
                }
            } else if (mode == 2) {
                if (j - 1 >= 0 && visited[i][j - 1] == 0) {
                    j--;
                } else {
                    i--;
                    mode = 3;
                }
            } else if (mode == 3) {
                if (i - 1 >= 0 && visited[i - 1][j] == 0) {
                    i--;
                } else {
                    j++;
                    mode = 0;
                }
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int[][] matrix1 = generateMatrix(1); // [[1]]
        int[][] matrix3 = generateMatrix(3); // [[1,2,3],[8,9,4],[7,6,5]]
        int[][] matrix4 = generateMatrix(4);
        
        System.out.println("matrix3 = " + ArrayUtils.Array2DToString(matrix3));
        System.out.println("matrix4 = " + ArrayUtils.Array2DToString(matrix4));
    }
}
