import java.util.Scanner;

public class Week09_038_02 {
    public static void main(String[] args) {
        long max = 0, sum = 0;
        double avg = 0;
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
            sum += scores[i];
            if (i > 0) {
                max = Math.max(scores[i], scores[i-1]);
            }
        }

        // 정수의 나눗셈은 소수점 이하가 버려지기 때문에 결과가 다르게 나올 수 있음
        // 형변환을 하거나 곱셈을 먼저 수행
        // avg = sum / max * 100 / N;
        avg = (sum / (double) max * 100) / N;
        // avg = (sum * 100 / max) / N;

        System.out.println(avg);
    }
}
