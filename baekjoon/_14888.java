import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _14888 {

    static int n;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int[] number;
    static int[] op;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        number = Arrays.stream(br.readLine().split(" ")).mapToInt(m -> Integer.parseInt(m)).toArray();
        op = Arrays.stream(br.readLine().split(" ")).mapToInt(m -> Integer.parseInt(m)).toArray();

        calc(number[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    // 0:+, 1:-, 2:*, 3:/
    static void calc(int num, int idx) {
        if (idx == n) {
            max = Math.max(num, max);
            min = Math.min(num, min);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;

                if (i == 0) {
                    calc(num+number[idx], idx+1);
                }
                else if (i == 1) {
                    calc(num-number[idx], idx+1);
                }
                else if (i == 2) {
                    calc(num*number[idx], idx+1);
                }
                else {
                    calc(num/number[idx], idx+1);
                }

                op[i]++;
            }
        }
    }

}
