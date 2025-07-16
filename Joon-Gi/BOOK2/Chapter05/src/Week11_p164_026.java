// [BOJ] 1260_DFS와 BFS

import java.util.*;
import java.io.*;

public class Week11_p164_026 {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 노드 수
        int M = Integer.parseInt(st.nextToken()); // 에지 수
        int V =  Integer.parseInt(st.nextToken()); // 시작점

        arr = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
            Collections.sort(arr[s]);
            Collections.sort(arr[e]);
        }

        visited = new boolean[N+1];
        //System.out.print(V + " ");
        DFS(V);

        System.out.println();

        visited = new boolean[N+1];
        BFS(V);
    }

    public static void DFS(int v) {
        if (visited[v]) return;
        System.out.print(v + " ");
        visited[v] = true; // 방문함
        for (int i : arr[v]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    public static void BFS(int v) {
        if (visited[v]) return;

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(v);
        visited[v] = true;

        while (!q.isEmpty()) {
            int a = q.poll();
            System.out.print(a + " ");
            for (int i : arr[a]) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
