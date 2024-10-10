package problems.lv1;

class CleanWallpaper {
    public int[] solution(String[] wallpaper) {
        int lux = wallpaper.length;
        int luy = wallpaper[0].length();
        int rdx = 0;
        int rdy = 0;
        
        for (int i = 0; i < wallpaper.length; i++) {
            String row = wallpaper[i];
            for (int j = 0; j < row.length(); j++) {
                if (row.charAt(j) == '#') {
                    lux = Math.min(lux, i);
                    rdx = Math.max(rdx, i + 1);
                    luy = Math.min(luy, j);
                    rdy = Math.max(rdy, j + 1);
                }
            }
        }
        
        return new int[]{lux, luy, rdx, rdy};
    }
}
