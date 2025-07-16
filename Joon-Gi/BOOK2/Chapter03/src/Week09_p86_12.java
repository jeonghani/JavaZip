// 백준 17298

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Week09_p86_12 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] answer = new int[N];

        Stack<Integer> S = new Stack<>();
        S.push(0);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            // arr[S.peek()]: 현재 비교하려는 값
            // arr[i]: i가 늘어나며 큰 지 비교
            while (!S.isEmpty() && arr[i] > arr[S.peek()]) {
                // 인덱스에 오큰수 저장
                answer[S.pop()] = arr[i];
            }
            S.push(i);
        }

        while (!S.isEmpty()) {
            answer[S.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i] + " ");
        }
        System.out.println(sb);
    }
}
