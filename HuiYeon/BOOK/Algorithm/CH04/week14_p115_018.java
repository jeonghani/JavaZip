package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class week14_p115_018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] A = new int [N];
        int [] S = new int [N];

        String [] str = br.readLine().split(" ");;
        for ( int i = 0; i < N; i++){
            A[i] = Integer.parseInt(str[i]);
        }

        for ( int i = 1; i < N ; i++){
            int flag = i;
            int value = A[i];
            for ( int j = i-1; j >= 0; j--){
                if(A[j] < A[i]){
                    flag = j+1;
                    break;
                }
                if (j == 0){
                    flag = 0;
                }
            }
            for ( int j = i; j > flag; j--){ // 만약 제자리라서 flag가 i라면 이 for문이 실행되지 않는다
                A[j] = A[j-1];
            }
            A[flag] = value;
        }
        S[0] = A[0];
        for (int i = 1; i < N; i++){
            S[i] = S[i-1] + A[i];
        }
        int sum = 0;
        for ( int i = 0; i < N; i++){
            sum = sum + S[i];
        }
        System.out.println(sum);
    }
}
