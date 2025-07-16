package Sort;
import java.io.*;
import java.io.IOException;
public class week13_p101_015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int [] cake = new int [n];

        for (int i = 0; i < n; i++){
            cake[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        bubble_sort(cake);
        for (int i = 0; i < n; i++) {
            bw.write(cake[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void bubble_sort(int [] A){
        for (int i = 0; i < A.length - 1; i++){
            for (int j = 0; j < A.length - 1 - i; j++){
                if(A[j] > A[j+1]){
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }
    }

}
