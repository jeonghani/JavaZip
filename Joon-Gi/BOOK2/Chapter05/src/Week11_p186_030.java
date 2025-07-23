// [BOJ] 2343_기타 레슨
// 블루레이의 최소 길이는 당연하게도 가장 긴 강의의 값
// 블루레이의 최대 길이는 모든 강의 길이의 합

import java.io.*;
import java.util.*;

public class Week11_p186_030 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int start = 0, end = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            start = Math.max(start, arr[i]);
            end += arr[i];
        }

        int result = end;

        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            int count = 1;

            for (int i = 0; i < N; i++) {
                if (sum + arr[i] > mid) {
                    count++;
                    sum = arr[i];
                } else {
                    sum += arr[i];
                }
            }

            if (count > M) {
                start = mid + 1;
            } else {
                result = mid; // 가능한 값 중 더 작은 값을 저장
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
