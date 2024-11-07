package problems.lv3;

import java.util.*;

class SheepAndWolf {
    List<Integer>[] tree;
    int max;
        
    public int solution(int[] info, int[][] edges) {
        max = 0;
        tree = new ArrayList[info.length];        
        for (int i = 0; i < tree.length; i++)
            tree[i] = new ArrayList<>();
        
        for (int[] edge : edges) 
            tree[edge[0]].add(edge[1]);
        
        traverse(info, 0, new HashSet<>(), 0, 0);
        
        return max;
    }
    
    public void traverse(int[] info, int currentNode, Set<Integer> nextNodes, int sheepCount, int wolfCount) {
        if (info[currentNode] == 0) {
            sheepCount++;
            max = Math.max(max, sheepCount);
        } else 
            wolfCount++;
        
        if (sheepCount <= wolfCount)
            return;
        
        for (int node : tree[currentNode])
            nextNodes.add(node);
        
        for (int node : nextNodes) {
            Set<Integer> newNextNodes = new HashSet<>(nextNodes);
            newNextNodes.remove(node);
            traverse(info, node, newNextNodes, sheepCount, wolfCount);
        }
    }
    
}
