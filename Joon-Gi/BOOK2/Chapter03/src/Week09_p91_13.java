// 백준 2164

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Week09_p91_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> Q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            Q.add(i);
        }

        while (Q.size() > 1) {
            Q.poll();
            int a = Q.poll();
            Q.add(a);
        }

        System.out.println(Q.peek());
    }
}
