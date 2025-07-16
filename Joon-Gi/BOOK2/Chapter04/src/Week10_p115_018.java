// [BOJ] 11399_ATM

import java.util.*;

public class Week10_p115_018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] S = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < N; i++) {
            int insert = i;
            int temp = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    insert = j + 1;
                    break;
                }
                if (j == 0) {
                    insert = 0;
                }
            }

            for (int j = i; j > insert; j--) {
                arr[j] = arr[j-1];
            }
            arr[insert] = temp;
        }

//        for (int i = arr.length; i > 1; i--) {
//            for (int j = 0; j < i - 1; j++) {
//                if (arr[j] > arr[j+1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }

        S[0] = arr[0];
        for (int i = 1; i < N; i++) {
            S[i] = S[i-1] + arr[i];
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += S[i];
        }
        System.out.println(sum);
    }
}
