package textbook.Week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _016_버블_소트_프로그램1_P1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        mData[] A = new mData[N];
        for (int i = 0; i < N; i++) {
            A[i] = new mData(Integer.parseInt(reader.readLine()), i);
        }

        Arrays.sort(A);

        int Max = 0;
        for (int i = 0; i < N; i++) {
            if (Max < A[i].index - i)
                Max = A[i].index - i;
                // A[i].index: 정렬하기 전의 위치
                // i: 정렬된 후의 위치
                // 정렬 전 index - 정렬 후 index 최댓값 Max에 저장
        }
        System.out.println(Max + 1);
    }
}   // 왼쪽으로 얼마나 많이 움직였는가 = 버블 정렬에서 필요한 반복 수
    // 10처럼 오른쪽으로 밀린 건 자연스러운 일이므로 중요하지 않음.
    // Max에서 정렬은 이미 끝났고, Max+1에서 정렬 유무를 확인해서 종료되므로 정답은 Max + 1

class mData implements Comparable<mData> {
    int value; // 정렬하려는 실제 숫자 값
    int index; // 입력 순서의 인덱스

    public mData(int value, int index) {
        super();
        this.value = value;
        this.index = index;
    }

    @Override // 반드시 compareTo 메서드를 재정의 해야함
    public int compareTo(mData o) {//value 기준 오름차순 정렬
        return this.value - o.value;
        // 값이 양수면 this가 o보다 크다(자리 바꿈)
        // 값이 음수면 this가 o보다 작다(자리 그대로)
        // 0이면 -> 같음
        // 즉, value를 기준으로 오름차순 정렬하겠다는 뜻
    }
}
