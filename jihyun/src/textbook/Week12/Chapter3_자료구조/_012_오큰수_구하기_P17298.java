package textbook.Week12.Chapter3_자료구조;

import java.util.*;
import java.io.*;

// https://upcurvewave.tistory.com/126 풀이방법 참조

public class _012_오큰수_구하기_P17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[size]; // 수열 배열
        for(int i = 0; i < size; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        int[] answer = new int[size]; // 정답 배열

        Stack<Integer> stack = new Stack<>(); // 수열의 인덱스를 담는 스택

        for(int i = 0; i < size; i++) {

            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) { // 오큰수인 경우
                answer[stack.pop()] = arr[i];
            }

            stack.push(i); // 스택이 비어있으면 push를 먼저 진행
        }

        // 반복문이 끝났을 때 스택에 쌓여있는 인덱스 (값이 채워지지 않은 배열) -1로 저장
        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < size; i++) {
            bw.write(answer[i] + " ");
        }
        // BufferedWriter : 출력 성능을 향상시키기 위해 버퍼를 가진 출력 스트림 (출력을 모아서 한꺼번에 내보냄 속도 ↑)
        // OutputStreamWriter : 바이트를 문자로 변환해줌
        // System.out : 출력 바이트 스트림

        bw.flush(); // 버퍼에 쌓인 내용을 한꺼번에 출력하는 코드
        // BufferedWriter 는 출력 내용을 버퍼에 잠시 보관하는 용도이므로 .flush() 반드시 사용해야 콘솔에 실제 출력됨
    }
}