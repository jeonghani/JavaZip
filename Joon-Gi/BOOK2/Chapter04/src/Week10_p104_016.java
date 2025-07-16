// [BOJ] 1377_버블 소트
// 다 정렬된 다음 i를 출력하라
// 언제 정렬이 다 된지 알 수 있는가?
// -> 가장 많이 왼쪽으로 움직여야 하는 원소가 제 자리를 찾아가면
// 하지만 왼쪽은 루프 1번에 1칸 씩 밖에 못 움직임
// 따라서, 정렬 전과 후의 인덱스를 비교하여 가장 큰 값을 찾기
// 루프가 마지막으로 한 번 더 돌면서 바꿀 게 없는지 확인하므로 +1

import java.io.*;
import java.util.*;

public class Week10_p104_016 {
    static class Data implements Comparable<Data> {
        int index;
        int value;

        public Data(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Data o) {
            // 오름차순, 큰 게 뒤로
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        Data[] arr = new Data[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new Data(i,  Integer.parseInt(br.readLine()));
        }
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            // 정렬 전 인덱스와 후 비교
            if (answer < arr[i].index - i) {
                answer = arr[i].index - i;
            }
        }
        System.out.println(answer+1);
    }
}
