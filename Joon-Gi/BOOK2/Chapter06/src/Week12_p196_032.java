// [BOJ] 11047_동전 0

import java.util.*;

public class Week12_p196_032 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] - K > 0) continue;

            while (K - arr[i] >= 0) {
                K -= arr[i];
                count++;
            }

            if (K == 0) break;

            // 책 풀이
//            if (arr[i] <= K) {
//                count += (K / arr[i]);
//                K = K % arr[i];
//            }
        }

        System.out.println(count);
    }
}
