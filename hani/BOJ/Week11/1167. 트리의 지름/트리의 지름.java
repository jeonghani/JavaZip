import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Edge>[] tree;
    static boolean[] visited;
    static int maxDist = 0;
    static int farNode = 0;

    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        tree = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                tree[from].add(new Edge(to, weight));
            }
        }

        // 1. 임의의 노드(1)에서 가장 먼 노드 찾기
        visited = new boolean[V + 1];
        bfs(1);

        // 2. 그 노드에서 가장 먼 노드까지의 거리(=지름) 찾기
        visited = new boolean[V + 1];
        maxDist = 0;
        bfs(farNode);

        System.out.println(maxDist);
    }

    static void bfs(int start) {
        Queue<Edge> queue = new LinkedList<>();
        queue.add(new Edge(start, 0));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Edge now = queue.poll();
            if (now.weight > maxDist) {
                maxDist = now.weight;
                farNode = now.to;
            }
            for (Edge next : tree[now.to]) {
                if (!visited[next.to]) {
                    visited[next.to] = true;
                    queue.add(new Edge(next.to, now.weight + next.weight));
                }
            }
        }
    }
}
