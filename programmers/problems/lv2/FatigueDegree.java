package problems.lv2;

class FatigueDegree {
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        for (int i = 0; i < dungeons.length; i++) {
            answer = Math.max(answer, traverse(k, i, 0, new boolean[dungeons.length], dungeons));
        }
        
        return answer;
    }
    
    public int traverse(int k, int dungeon, int depth, boolean[] visited, int[][] dungeons) {
        if (k < dungeons[dungeon][0])
            return depth;
        else if (depth == visited.length - 1)
            return visited.length;
        
        visited[dungeon] = true;
        int max = depth;
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                max = Math.max(max, traverse(k - dungeons[dungeon][1], i, depth + 1, visited, dungeons));
            }
        }
        visited[dungeon] = false;
        
        return max;
    }
}
