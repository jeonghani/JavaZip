// [BOJ] 11724_연결 요소의 개수

import java.io.*;
import java.util.*;

public class Week11_p148_023 {
    static ArrayList<Integer>[] arr;
    static boolean visited[];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 노드 수
        int M = Integer.parseInt(st.nextToken()); // 에지 수
        // 인접 리스트
        arr = new ArrayList[N+1];
        // 방문 배열
        visited = new boolean[N+1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            // 양방향 에지이므로 양쪽에 에지를 더하기
            arr[s].add(e);
            arr[e].add(s);
        }

        // DFS 실행 횟수 -> 연결 요소의 개수
        int count = 0;
        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }

    static void DFS(int v) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        for (int i : arr[v]) {
            // 방문하지 않은 노드면 탐색
            if (visited[i] == false) {
                DFS(i);
            }
        }
    }
}
