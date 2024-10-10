import problems.lv0;

class IntegerToSpiralArray {
    public static void main(String[] args) {
        int[][] e1 = solution(4);
        int[][] e2 = solution(5);

        for (int[] ints : e1) {
            print(ints);
        }
        for (int[] ints : e2) {
            print(ints);
        }
    }

    public static void print(int[] arr) {
        System.out.print("[");
        String collect = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(collect + "]");
    }
  
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        int cnt = 1;
        int row = 0;
        int column = 0;
        int idx = 0;
        
        while (cnt <= n * n) {
            answer[row][column] = cnt++;
            
            int[] nextDirection = direction[idx];
            if (idx == 0) {
                if (column == n - 1 || answer[row + nextDirection[0]][column + nextDirection[1]] != 0) {
                    idx = 1;
                    nextDirection = direction[idx];
                } 
                row += nextDirection[0];
                column += nextDirection[1];
            } else if (idx == 1) {
                if (row >= n - 1 || answer[row + nextDirection[0]][column + nextDirection[1]] != 0) {
                    idx = 2;
                    nextDirection = direction[idx];
                }
                row += nextDirection[0];
                column += nextDirection[1];
            } else if (idx == 2) {
                if (column <= 0 || answer[row + nextDirection[0]][column + nextDirection[1]] != 0) {
                    idx = 3;
                    nextDirection = direction[idx];
                }
                row += nextDirection[0];
                column += nextDirection[1];
            } else if (idx == 3) {
                if (row <= 0 || answer[row + nextDirection[0]][column + nextDirection[1]] != 0) {
                    idx = 0;
                    nextDirection = direction[idx];
                }
                row += nextDirection[0];
                column += nextDirection[1];
            }
        }
        
        return answer;
    }
}
