// [BOJ] 2178_미로 탐색

import java.util.*;
import java.io.*;

public class Week11_p169_027 {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상, 하
    static int[] dy = {0, 0, -1, 1}; // 좌, 우
    static int N, M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 1; j < M+1; j++) {
                arr[i][j] = Integer.parseInt(s.substring(j-1, j));
            }
        }

        BFS(1, 1);
        System.out.println(arr[N][M]);
    }

    public static void BFS(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] a = q.poll();

            for (int k = 0; k < 4; k++) {
                int x = a[0] + dx[k];
                int y = a[1] + dy[k];
                if (x > 0 && y > 0 && x <= N && y <= M) {
                    if (!visited[x][y] && arr[x][y] == 1) {
                        arr[x][y] = arr[a[0]][a[1]] + 1; // 이전 좌표값에 1을 더해 업데이트
                        q.add(new int[] {x, y});
                        visited[x][y] = true;
                    }
                }
            }
        }

    }
}
