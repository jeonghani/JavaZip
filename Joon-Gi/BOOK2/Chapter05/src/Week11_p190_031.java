// [BOJ] 1300_K번째 수
// k가 min(10^9, N^2)이니 N이 최대값 N^5일 때 k는 min(10^9, 10^10) -> 10^9임
// 따라서, 시간 복잡도가 N^2인 알고리즘은 사용할 수 없음
// 거대한 범위에서 조건에 맞는 k번째 수 찾기
// 1. 정답 값의 범위 정하기 (1 ~ min(10^9, N^2)
// 2. 중간값 mid를 정답 후보로 뽑기
// 3. mid보다 작거나 같은 수의 개수 세기
// 4. 만약 그 개수가 k개 이상이라면 -> 왼쪽 구간 / k개 미만이라면 -> 오른쪽 구간

import java.util.*;

public class Week11_p190_031 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int k = sc.nextInt();

        int start = 1, end = k;
        int mid = 0, count = 0, answer = 0;

        while (start <= end) {
            mid = start + (end - start) / 2;
            count = 0;

            for (int i = 1; i <= N; i++) {
                count += Math.min(N, mid / i);
            }

            if (count >= k) {
                end = mid - 1;
                answer = mid;
            }
            else start = mid + 1;
        }

        System.out.println(answer);
    }
}
