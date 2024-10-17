package problems.lv3;

import java.util.*;
import java.util.stream.*;

class SharedTaxiFare {

    //Floyd-Warshall algorithm
    public int solution1(int n, int s, int a, int b, int[][] fares) {
        int[][] distance = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            Arrays.fill(distance[i], 100000000);
            distance[i][i] = 0;
        }
        
        for (int[] fare : fares) {
            distance[fare[0]][fare[1]] = fare[2];
            distance[fare[1]][fare[0]] = fare[2];
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        int min = distance[s][a] + distance[s][b];
        for (int i = 1; i <= n; i++) {
            min = Math.min(min, distance[s][i] + distance[i][a] + distance[i][b]);
        }
        
        return min;
    }


    //Dijkstra algorithm
    class Node {
        int index;
        int cost;
        
        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append("index = " + index);
            sb.append(", ");
            sb.append("cost = " + cost);
            sb.append(")");
            
            return sb.toString();
        }
    }
    
    public int solution2(int n, int s, int a, int b, int[][] fares) {
        List<List<Node>> graph = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < fares.length; i++) {
            graph.get(fares[i][0]).add(new Node(fares[i][1], fares[i][2]));
            graph.get(fares[i][1]).add(new Node(fares[i][0], fares[i][2]));
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            min = Math.min(min, distance(graph, s, i) + distance(graph, i, a) + distance(graph, i , b));
        }
        
        return min;
    }
    
    public int distance(List<List<Node>> graph, int start, int end) {
        int[] distance = new int[graph.size()];
        Arrays.fill(distance, 100000 * graph.size());
        distance[start] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> (Integer.compare(n1.cost, n2.cost)));
        pq.offer(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            
            if (current.index == end)
                break;
            
            if (distance[current.index] < current.cost)
                continue;
            
            for (Node next : graph.get(current.index)) {
                if (distance[next.index] > distance[current.index] + next.cost) {
                    distance[next.index] = distance[current.index] + next.cost;
                    pq.offer(new Node(next.index, distance[next.index]));
                }
            }
        }
        
        return distance[end];
    }
}
