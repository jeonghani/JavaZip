package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class week14_p109_017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int [] A = new int[str.length()];
        for (int i = 0; i < str.length(); i++){
            A[i] = Integer.parseInt(str.substring(i, i+1));
        }
        for (int i = 0; i < str.length(); i++){
            int Max = i;
            for (int j = i; j < str.length(); j++){
                if (A[j] > A[Max]){
                    Max = j;
                }
            }
            if (A[i] < A[Max]){
                int temp = A[i];
                A[i] = A[Max];
                A[Max] = temp;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            sb.append(A[i]);
        }
        System.out.print(sb);
    }
}
