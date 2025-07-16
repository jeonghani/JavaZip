package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class week14_p128_020 {
    public static int[] A, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 1번 인덱스부터 사용
        A = new int[N + 1];
        temp = new int[N + 1];


        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(1, N);

        for (int i = 1; i <= N; i++) {
            sb.append(A[i]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    public static void mergeSort(int start, int end) {
        // 재귀 호출의 기저 조건
        if (start >= end) {
            return;
        }

        int m = start + (end - start) / 2;

        // 왼쪽 덩어리 나누기
        mergeSort(start, m);
        // 오른쪽 덩어리 나누기
        mergeSort(m + 1, end);

        for (int i = start; i <= end; i++) {
            temp[i] = A[i];
        }

        int k = start; // A 배열에 결과를 저장할 현재 위치
        int index1 = start;
        int index2 = m + 1;

        // 두 부분 배열을 비교하여 A 배열에 정렬된 순서로 저장
        while (index1 <= m && index2 <= end) {
            if (temp[index1] > temp[index2]) {
                A[k] = temp[index2];
                k++;
                index2++;
            } else {
                A[k] = temp[index1];
                k++;
                index1++;
            }
        }

        // 왼쪽 부분 배열에 남은 요소들을 A 배열에 복사
        while (index1 <= m) { // 이전에 처리되지 못한 나머지 요소들을 복사
            A[k] = temp[index1];
            k++;
            index1++;
        }

        while (index2 <= end){ // 이전에 처리되지 못한 나머지 요소들을 복사
            A[k] = temp[index2];
            k++;
            index2++;
        }
    }
}