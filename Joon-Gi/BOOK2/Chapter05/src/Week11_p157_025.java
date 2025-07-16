// [BOJ] 13023_ABCDE

import java.util.*;
import java.io.*;

public class Week11_p157_025 {
    static ArrayList<Integer>[] arr; // 인접 리스트
    static boolean[] visited; // 방문 배열
    static boolean arrive;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 노드 수
        int M = Integer.parseInt(st.nextToken()); // 에지 수

        visited = new boolean[N];
        arr = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        arrive = false;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s =  Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }

        for (int i = 0; i < N; i++) {
            DFS(i, 1);
            if (arrive) {
                break;
            }
        }
        if (arrive) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    static void DFS(int v, int depth) {
        if (visited[v]) {
            return;
        }
        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }
        visited[v] = true;
        for (int i : arr[v]) {
            if (!visited[i]) {
                DFS(i, depth + 1);
            }
        }

        // 백 트래킹
        visited[v] = false;
    }
}
