package textbook.Week12.Chapter3_자료구조;

import java.io.*;
import java.util.*;

public class _014_절댓값_힙_구현하기_P11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>( // default: 오름차순
                (a, b) -> { // 람다식 → Comparator 인터페이스 compare(a, b)
                    int abs_a = Math.abs(a);
                    int abs_b = Math.abs(b);

                    if(abs_a == abs_b) { // 절댓값이 같은 경우
                        return a - b; // 작은 값이 앞에 오도록 정렬
                    }
                    else
                        return abs_a - abs_b; // 절댓값을 기준으로 정렬하기
                }
        );

        for(int i = 0; i < size; i++) {
            int input = Integer.valueOf(br.readLine());


        }
    }
}
