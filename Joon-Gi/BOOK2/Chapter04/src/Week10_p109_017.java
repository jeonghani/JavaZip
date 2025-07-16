// [BOJ] 1427_소트인사이드

import java.util.Scanner;

public class Week10_p109_017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] arr = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            arr[i] = Integer.parseInt(str.substring(i, i+1));
        }

        for (int i = 0; i < arr.length; i++) {
            int max = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] > max) {
                    max = j;
                }
            }

            if (arr[max] > arr[i]) {
                int temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;
            }
        }

        for (int i : arr) {
            System.out.print(i);
        }
    }
}
