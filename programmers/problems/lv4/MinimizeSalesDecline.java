package problems.lv4;

import java.util.*;

class MinimizeSalesDecline {
    List<Integer>[] team;
    int[][] cost;
    
    public int solution(int[] sales, int[][] links) {
        team = new ArrayList[sales.length];        
        cost = new int[sales.length][2];
        
        for (int i = 0; i < team.length; i++)
            team[i] = new ArrayList<>();
         
        for (int[] link : links) 
            team[link[0] - 1].add(link[1] - 1);
        
        dfs(sales, 0);
        
        return Math.min(cost[0][0], cost[0][1]);
    }
    
    public void dfs(int[] sales, int member) {
        cost[member][0] = 0;
        cost[member][1] = sales[member];
        
        if (team[member].size() == 0)
            return;
        
        int minCost = Integer.MAX_VALUE;
        for (int teamMates : team[member]) {
            dfs(sales, teamMates);
            
            if (cost[teamMates][0] > cost[teamMates][1]) {
                cost[member][0] += cost[teamMates][1];
                cost[member][1] += cost[teamMates][1];
                minCost = 0;
            } else {
                cost[member][0] += cost[teamMates][0];
                cost[member][1] += cost[teamMates][0];
                minCost = Math.min(minCost, cost[teamMates][1] - cost[teamMates][0]);
            }
        }
        cost[member][0] += minCost;
    }
}
