// [BOJ] 1920_수 찾기

import java.io.*;
import java.util.*;

public class Week11_p182_029 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] arrToFind = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arrToFind[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for (int i = 0; i < M; i++) {
            System.out.println(binarySearch(arr, N, arrToFind[i]));
        }

    }

    public static int binarySearch(int[] arr, int length, int target) {
        int start = 0;
        int end = length - 1;
        int mid = start + (end - start) / 2;

        while (start <= end) {
            if (arr[mid] == target) {
                return 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
                mid = start + (end - start) / 2;
            } else if (arr[mid] > target) {
                end = mid - 1;
                mid = start + (end - start) / 2;
            }
        }
        return 0;
    }
}
