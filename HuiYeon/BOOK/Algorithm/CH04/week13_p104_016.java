package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class week13_p104_016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        mSet[] cake = new mSet[n];

        for (int i = 0; i < n; i++){
            cake[i] = new mSet(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(cake);
        int max = 0;

        for(int i = 0; i < n; i++){
            if (max < cake[i].index-i) {
                max = cake[i].index - i;
            }
        }
        System.out.println(max + 1);
    }
}
class mSet implements Comparable<mSet>{
    int value;
    int index;

    public mSet(int value, int index){
        super();
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(mSet o){
        return this.value - o.value;
    }
}

