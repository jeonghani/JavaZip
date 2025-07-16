import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(' ');
        for (int nv : graph[v]) {
            if (!visited[nv]) {
                dfs(nv);
            }
        }
    }

    public static void bfs(int start) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            sb.append(v).append(' ');
            for (int nv : graph[v]) {
                if (!visited[nv]) {
                    visited[nv] = true;
                    queue.add(nv);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        visited = new boolean[N + 1];
        dfs(V);
        System.out.println(sb.toString().trim());

        sb.setLength(0);
        bfs(V);
        System.out.println(sb.toString().trim());
    }
}
