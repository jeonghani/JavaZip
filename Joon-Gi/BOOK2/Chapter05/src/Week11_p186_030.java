// [BOJ] 2343_기타 레슨
// 블루레이의 최소 길이는 당연하게도 가장 긴 강의의 값
// 블루레이의 최대 길이는 모든 강의 길이의 합

import java.io.*;
import java.util.*;

public class Week11_p186_030 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 레슨 수
        int M = Integer.parseInt(st.nextToken()); // 블루레이 개수

        int[] arr = new int[N];

        int start = 0, end = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > start) {
                start = arr[i];
            }
            end += arr[i];
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int sum = 0;
            int count = 1;

            for (int i = 0; i < N; i++) {
                // 만약 현재 레슨 시간 > 중간 인덱스면 새 블루레이 저장 후 sum 리셋
                if (sum + arr[i] > mid) {
                    count++;
                    sum = arr[i];
                } else {
                    sum += arr[i];
                }

                if (count > M) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        System.out.println(start);
    }
}
