package CH03;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class week10_p91_013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 링크드 리스트 큐큐
        Queue<Integer> myQueue = new LinkedList<>();
        int N = sc.nextInt();
        // 1 ~ N까지 정수 큐에 넣기기
        for (int i = 1; i <= N; i++) {
            myQueue.add(i);
        }
        // 1장 남을 때 까지지
        while (myQueue.size() > 1) {
            myQueue.poll(); // 가장 앞 요소 제거거
            myQueue.add(myQueue.poll()); // 큐 뒤에 맨앞 정수를 추가가
        }
        System.out.println(myQueue.poll());
    }
}
