package Shortest_path;
import java.util.*;

public class Dijkstra {
    public static int[] dijkstra(int[][] graph, int source) {
        int n = graph.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> dist[a] - dist[b]);
        pq.offer(source);
        while (!pq.isEmpty()) {
            int u = pq.poll();
            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && dist[v] > dist[u] + graph[u][v]) {
                    dist[v] = dist[u] + graph[u][v];
                    pq.offer(v);
                }
            }
        } return dist;
    }
    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 6, 0, 7, 0},
                {8, 11, 0, 0, 0, 0, 7, 0, 0},
                {0, 0, 2, 0, 0, 0, 0, 0, 0}
        };
        int[] distances = dijkstra(graph, 0);
        for (int d : distances) {
            System.out.print(d + " ");
        }
    }
}
