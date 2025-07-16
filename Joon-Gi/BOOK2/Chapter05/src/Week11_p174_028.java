// [BOJ] 1167_트리의 지름
// 노드 사이에 가장 긴 거리 = 트리의 지름

import java.io.*;
import java.util.*;

class Edge {
    int e; // 에지
    int value; // 거리(가중치)

    public Edge(int e, int value) {
        this.e = e;
        this.value = value;
    }
}

public class Week11_p174_028 {
    static ArrayList<Edge>[] arr;
    static boolean[] visited;
    static int[] distance;
    static int V, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        arr = new ArrayList[V+1];
        visited = new boolean[V+1];
        distance = new int[V+1];
        max = 0;

        for (int i = 1; i <= V; i++) {
            arr[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // N번째 노드
            while (true) {
                int e = Integer.parseInt(st.nextToken()); // 에지
                if (e == -1) break;
                int d = Integer.parseInt(st.nextToken()); // 거리
                arr[N].add(new Edge(e, d));
            }
        }

        // 임의의 점
        // 1차 탐색 (A -> B): 아무데서나 시작해도 그 곳에서 가장 먼 노드(B)를 찾으면 그건 진짜 지름의 한쪽 끝임이 보장된다
        BFS(1);

        int idx = 0;
        for (int i = 1; i <= V; i++) {
            if (distance[i] > max) {
                max = distance[i];
                idx = i;
            }
        }

        // 임의의 점으로부터 가장 먼 노드에서 다시 한 번 더
        // 2차 탐색 (B -> C): B가 지름 중 하나의 점임을 알았으니 B에서 가장 먼 노드 찾기
        visited = new boolean[V+1];
        distance = new int[V+1];
        BFS(idx);

        for (int i = 1; i <= V; i++) {
            if (distance[i] > max) {
                max = distance[i];
            }
        }
        System.out.println(max);
    }

    public static void BFS(int v) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(v);
        visited[v] = true;

        while (!q.isEmpty()) {
            int a = q.poll();
            for (Edge e : arr[a]) {
                if (!visited[e.e]) {
                    q.add(e.e);
                    visited[e.e] = true;
                    // 거리 업데이트
                    // 새 노드까지의 거리 = 지금까지의 거리 + 새 노드의 거리
                    distance[e.e] = distance[a] + e.value;
                }
            }

        }
    }
}
