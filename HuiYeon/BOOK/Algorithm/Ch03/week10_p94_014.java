package CH03;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
public class week10_p94_014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> MyQueue = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            // 절댓값 비교
            // 작은 수 우선(같으면 음수)
            if (first_abs == second_abs)
                return o1 > o2 ? 1 : -1;
            else
                return first_abs - second_abs;
        });
        for (int i = 0; i < N; i++) {
            // 요청 처리
            int request = Integer.parseInt(br.readLine());
            if (request == 0) {
                // 큐가 비어있으면 0 출력
                if (MyQueue.isEmpty())
                    System.out.println("0");
                else
                // 정렬된 큐에서 하나 꺼내기
                    System.out.println(MyQueue.poll());
            } else {
                // 요청이 0이 아니면 큐에 추가
                MyQueue.add(request);
            }
        }
    }
}
