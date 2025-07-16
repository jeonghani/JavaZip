// 백준 1874

import java.util.Scanner;
import java.util.Stack;

import java.util.*;
import java.io.*;

public class Week09_p81_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        Stack<Integer> S = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int num = 1;

        for (int i = 0; i < N; i++) {
            while (arr[i] >= num) {
                S.push(num);
                sb.append("+\n");
                num++;
            }

            if (S.peek() == arr[i]){
                S.pop();
                sb.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb.toString());

        sc.close();
    }
}
