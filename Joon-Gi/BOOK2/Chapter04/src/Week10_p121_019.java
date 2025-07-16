// [BOJ] 11004_K번째 수

import java.util.*;
import java.io.*;

public class Week10_p121_019 {
    public static void main(String[] args) throws IOException {
        // 이전 코드와 동일 (입력 처리)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr, 0, N - 1);
        System.out.println(arr[K - 1]);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (right - left < 2) {
            if (right - left == 1 && arr[left] > arr[right]) {
                swap(arr, left, right);
            }
            return;
        }

        // 중앙값으로 피벗 설정
        int pivot = getMedian(arr, left, right);

        int i = left;
        int j = right - 1; // 피벗이 right-1 위치에 있으므로 j는 여기서 시작

        while (true) {
            // 왼쪽에서는 피벗보다 큰 값을 찾음
            while (arr[++i] < pivot) {}
            // 오른쪽에서는 피벗보다 작은 값을 찾음
            while (arr[--j] > pivot) {}

            if (i >= j) {
                break;
            }
            // i와 j가 가리키는 값을 교환
            swap(arr, i, j);
        }

        // 3. 마지막으로 피벗을 제자리로 옮김 (i 위치)
        swap(arr, i, right - 1);

        // 4. 분할된 부분에 대해 재귀 호출
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    // Median-of-Three 로직을 담은 함수
    private static int getMedian(int[] arr, int left, int right) {
        int center = (left + right) / 2;

        // [Step 1] 세 후보 값을 크기 순으로 정렬 (arr[left] < arr[center] < arr[right])
        if (arr[left] > arr[center]) {
            swap(arr, left, center);
        }
        if (arr[left] > arr[right]) {
            swap(arr, left, right);
        }
        if (arr[center] > arr[right]) {
            swap(arr, center, right);
        }

        // [Step 2] 중간 값(arr[center])을 피벗으로 선택하고,
        // 파티션 작업을 편하게 하기 위해 맨 뒤에서 두 번째(right-1) 위치로 보냄
        swap(arr, center, right - 1);

        // 선택된 피벗 값을 반환
        return arr[right - 1];
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
