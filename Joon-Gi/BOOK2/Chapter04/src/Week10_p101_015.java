// [BOJ] 2750_수 정렬하기1

import java.util.Scanner;

public class Week10_p101_015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = arr.length; i > 1; i--) {
            for (int j = 0; j < i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                } else {
                    continue;
                }
            }
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
