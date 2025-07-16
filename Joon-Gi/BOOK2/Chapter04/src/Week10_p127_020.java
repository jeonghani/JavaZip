// [BOJ] 2751_수 정렬하기 2

import java.io.*;

public class Week10_p127_020 {
    public static int[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        temp = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(A, 0, N-1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(A[i] + "\n");
        }
        System.out.println(sb.toString());
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;

        // 재귀를 매번 호출할 때마다 생성하니 메모리 초과
        // int[] temp = new int[arr.length];

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }

        // 두 그룹 병합
        int k = start;
        int idx1 = start;
        int idx2 = mid + 1;

        while (idx1 <= mid && idx2 <= end) {
            if (temp[idx1] > temp[idx2]) {
                arr[k] = temp[idx2];
                k++;
                idx2++;
            } else {
                arr[k] = temp[idx1];
                k++;
                idx1++;
            }
        }

        // 한 쪽 그룹 모두 선택된 후 남아 있는 값 정리
        while (idx1 <= mid) {
            arr[k] = temp[idx1];
            k++;
            idx1++;
        }
        while (idx2 <= end) {
            arr[k] = temp[idx2];
            k++;
            idx2++;
        }
    }
}