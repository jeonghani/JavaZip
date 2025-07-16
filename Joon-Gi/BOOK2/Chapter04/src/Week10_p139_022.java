// [BOJ] 10989_수 정렬하기 3

import java.io.*;
import java.util.*;

public class Week10_p139_022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 계수 정렬(Counting Sort)
        // 입력값의 최대가 10000
        int[] arr = new int[10001];

        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            while (arr[i] > 0) {
                sb.append(i + "\n");
                arr[i]--;
            }
        }

        System.out.println(sb.toString());
        br.close();
    }

    // 기수 정렬 코드 -> 천만 개라 메모리 초과
    public static void radixSort(int[] arr, int N, int max) {
        Queue<Integer>[] buckets = new Queue[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new LinkedList<>();
        }

        // k: 1 -> 10 -> 100...
        for (int k = 1; max / k > 0; k *= 10) {
            for (int i = 0; i < N; i++) {
                // 현재 자릿수의 숫자
                int digit = (arr[i] / k) % 10;
                buckets[digit].add(arr[i]);
            }

            int idx = 0;
            for (int i = 0; i < 10; i++) {
                while (!buckets[i].isEmpty()) {
                    arr[idx++] = buckets[i].poll();
                }
            }
        }
    }
}
