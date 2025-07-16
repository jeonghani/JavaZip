// [BOJ] 1541_잃어버린 괄호

import java.util.*;

public class Week12_p211_036 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String[] str = s.split("-");

        int sum = 0;
        int answer = 0;
        for (int i = 0; i < str.length; i++) {
            sum = 0;
            String[] plus = str[i].split("\\+");

            for (int j = 0; j < plus.length; j++) {
                sum += Integer.parseInt(plus[j]);
            }
            if (i == 0) answer += sum;
            else answer -= sum;
        }

        System.out.println(answer);
    }
}
