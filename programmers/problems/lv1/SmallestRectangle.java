package problems.lv1;

class SmallestRectangle {
    public int solution(int[][] sizes) {
        int minWidth = 0;
        int minHeight = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            int width = Math.min(sizes[i][0], sizes[i][1]);
            int height = Math.max(sizes[i][0], sizes[i][1]);

            minWidth = Math.max(minWidth, width);
            minHeight = Math.max(minHeight, height);
        }
        
        return minWidth * minHeight;
    }
}
