// [BOJ] 1715_카드 정렬하기

import java.util.*;

public class Week12_p199_033 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int k = sc.nextInt();
            pq.offer(k);
        }

        int a = 0, b = 0, sum = 0;
        int answer = 0;
        while (pq.size() > 1) {
            a = pq.poll();
            b = pq.poll();
            sum = a + b;
            pq.offer(sum);
            answer += sum;
        }
        System.out.println(answer);
    }
}
