package problems.lv3;

class TravelRoute {
    String[] answer;
    
    public String[] solution(String[][] tickets) {
        answer = new String[tickets.length + 1];
        
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                dfs(tickets, new boolean[tickets.length], i, 0, new String[tickets.length + 1]);            
            }
        }
        
        return answer;
    }
    
    public void dfs(String[][] tickets, boolean[] visited, int index, int depth, String[] path) {
        if (visited[index])
            return;
        
        String[] ticket = tickets[index];
        path[depth++] = ticket[0];
        path[depth] = ticket[1];
        
        visited[index] = true;
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(ticket[1])) {
                dfs(tickets, visited, i, depth, path);
            }
        }
        visited[index] = false;
        
        if (depth == path.length - 1) {
            String[] compared = comparePath(answer, path);
            int n = 0;
            for (String str : compared) {
                answer[n++] = str;
            }
        }
    }
    
    private String[] comparePath(String[] path1, String[] path2) {
        for (int i = 0; i < path1.length; i++) {
            if (path1[i] == null) {
                return path2;
            } else if (path1[i].compareTo(path2[i]) < 0) {
                return path1;
            } else if (path1[i].compareTo(path2[i]) > 0) {
                return path2;
            }
        }
        
        return path2;
    }
}
