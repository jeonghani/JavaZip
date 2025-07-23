// [BOJ] 1744_수 묶기

import java.util.*;

public class Week12_p203_034 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int zeroCnt = 0;
        PriorityQueue<Integer> pqN = new PriorityQueue<>(); // 음수 큐
        PriorityQueue<Integer> pqP = new PriorityQueue<>(Collections.reverseOrder()); // 양수 큐

        int k = 0;
        for (int i = 0; i < N; i++) {
            k = sc.nextInt();

            if (k > 0) pqP.offer(k);
            else if (k < 0) pqN.offer(k);
            else zeroCnt++;
        }

        int a = 0, b = 0, sum = 0;
        // 양수
        while (pqP.size() > 1) {
            a = pqP.remove();
            b = pqP.remove();

            if (a == 1 || b == 1) sum += a + b;
            else sum += a * b;
        }
        // 남아있는 1 전부 더하기 또는 하나 남은 2 이상의 값 더하기
        while (!pqP.isEmpty()) {
            sum += pqP.remove();
        }

        // 음수
        while (pqN.size() > 1) {
            a = pqN.remove();
            b = pqN.remove();
            sum += a * b;
        }

        // 0이 있다면?
        if (zeroCnt > 0) {
            System.out.println(sum);
        } else {
            if (pqN.size() == 1) {
                sum += pqN.poll();
                System.out.println(sum);
            } else {
                System.out.println(sum);
            }
        }
    }
}
