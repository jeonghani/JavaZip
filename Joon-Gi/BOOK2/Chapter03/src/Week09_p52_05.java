import java.util.*;
import java.io.*;

public class Week09_p52_05 {
    public static void main(String[] args) throws IOException {
        long answer = 0;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] R =  new long[M];
        long sum = 0;

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            sum += Long.parseLong(st.nextToken());

            int remainder = (int) (sum % M);

            // 1. S[j] % M == 0
            if (remainder == 0) {
                answer++;
            }

            // 2. (S[j] - S[i-1]) % M = 0 -> S[j] % M = S[i-1] % M
            // (i-1, j) 쌍 찾기
            answer += R[remainder];

            R[remainder]++;
        }

        // 2. (S[j] - S[i-1]) % M = 0 -> S[j] % M = S[i-1] % M
        // (i-1, j) 쌍 찾기
//        for (int i = 0; i < M; i++) {
//            if (R[i] > 0) {
//                // R[i]는 i로 떨어지는 구간의 개수
//                // nC2 = n(n-1)/2
//                answer += R[i] * (R[i] - 1) / 2;
//            }
//        }

        System.out.println(answer);
    }
}
