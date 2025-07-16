// 백준 11286

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Week09_p94_14 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 우선순위 큐 정렬 기준 설정 방법
        PriorityQueue<Integer> PQ = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);

            // 절댓값이 같으면 음수 우선
            if (absA == absB)
                // 반환 값이 양수면 a가 b보다 뒤에 있다 (우선 순위가 낮다)
                // 반환 값이 음수면 a가 b보다 앞에 온다 (우선 순위가 높다)
                return a > b ? 1 : -1;
            else
                // 다르면 절댓값 기준으로 정렬
                // absA가 absB보다 크면 양수를 return 할테니 absA가 absB보다 뒤에 있음
                return absA - absB;
        });

        for (int i = 0; i < N; i++) {
            int x =  Integer.parseInt(br.readLine());
            if (x == 0) {
                if (PQ.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(PQ.poll());
                }
            } else {
                PQ.add(x);
            }
        }
    }
}
