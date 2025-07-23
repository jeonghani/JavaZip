package textbook.Week14;

// 1 2 3 4 5
// |-----|
// |-- <-|

import java.util.*;

public class _015_수_정렬하기1_P2750 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] arr = new int[size];

        for(int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        for(int i = 0; i < size - 1; i++) {
            for(int j = 0; j < size - 1 - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for(int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
    }
}
