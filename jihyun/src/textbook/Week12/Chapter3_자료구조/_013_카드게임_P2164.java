package textbook.Week12.Chapter3_자료구조;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class _013_카드게임_P2164 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        Queue<Integer> queue = new LinkedList<>(); // new Queue<>();는 Stack(클래스)와 다르게 불가(인터페이스임)
        for(int i = 1; i <= input; i++) { // 카드는 1부터 n까지 이므로 i = 1부터 시작
            queue.add(i); // 큐에 카드 저장하기
        }

        while(queue.size() > 1) {
            queue.poll(); // 맨 앞 카드 버리기
            int temp = queue.peek();
            queue.add(temp);
            queue.poll();
        }

        System.out.println(queue.peek());
    }
}
