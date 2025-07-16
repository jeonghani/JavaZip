package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class week14_p121_019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        String [] str2 = br.readLine().split(" ");
        int [] A = new int [N];

        for (int i = 0; i < N; i++){
            A[i] = Integer.parseInt(str2[i]);
        }
        quickSort(A, 0, N - 1, K - 1);
        System.out.println(A[K-1]);

    }
    public static void quickSort( int [] arr, int low, int high, int k){
        // 경우에 따라서 한 쪽에서만 퀵정렬 진행 -> 시간 복잡도 감소
        if (low < high){
            int pivotIndex = partition(arr, low, high);

            if (pivotIndex == k){
                return;
            }
            else if (k < pivotIndex){
                quickSort(arr, low, pivotIndex -1, k);
            }
            else {
                quickSort(arr, pivotIndex + 1, high, k);
            }
        }
    }
    private static int partition(int[] A, int S, int E){
        // 재귀 종료 조건
        if(S + 1 == E) {
            if(A[S]>A[E]){
                swap(A,S,E);
            }
            return E;
        }

        int M = (S + E) / 2;
        swap(A, S, M); // 중앙값을 1번째 요소로 이동하기
        int pivot = A[S];
        int i = S+1, j = E;

        while (i <= j) {
            while (j>= S+1 && pivot < A[j]){   //피벗보다 작은 수가 나올때까지 j--
                j--;
            }
            while (i<= E && pivot > A[i]){  //피벗보다 큰 수가 나올 떄까지 i++
                i ++;
            }
            if (i < j) {
                swap (A, i++, j--);  // 찾은 i와 j를 교환하기
            }else{
                break;
            }
        }
        // i == j 피벗의 값을 양쪽으로 분리한 가운데에 오도록 설정하기
        A[S] = A[j];
        A[j] = pivot;
        return j;
    }

    public static void swap(int [] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
