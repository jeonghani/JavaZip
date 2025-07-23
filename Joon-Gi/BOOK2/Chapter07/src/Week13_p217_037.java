// [BOJ] 1929_소수 구하기

import java.util.*;

public class Week13_p217_037 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        // 책에서는 int[]을 이용해 소수가 아니면 0으로
        boolean[] isPrime = new boolean[N+1];

        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (isPrime[i]) {
                // i보다 작은 배수들은 이미 이전 단계에서 지워졌으므로 i * i도 가능
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                System.out.println(i);
            }
        }
    }
}
