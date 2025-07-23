import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[][] meetings = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            meetings[i][0] = Integer.parseInt(split[0]);
            meetings[i][1] = Integer.parseInt(split[1]);
        }
        Arrays.sort(meetings, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int count = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            if (meetings[i][0] >= end) {
                end = meetings[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
