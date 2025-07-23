// [BOJ] 1931_회의실 배정
// 끝나는 시간이 빠른 것부터 고른다

import java.util.*;
import java.io.*;

public class Week12_p207_035 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            arr[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        int count = 0, end = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i][0] >= end) {
                end = arr[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}

//0 6
//1 4
//2 13
//3 5
//3 8
//5 7
//5 9
//6 10
//8 11
//8 12
//12 14


//1 4 V
//3 5
//0 6
//5 7 V
//3 8
//5 9
//6 10
//8 11 V
//8 12
//2 13
//12 14 V
