import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] arr = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int res = 0;
        int idx = 0;
        for (int i = 1; i < w; i++) {
            if (arr[idx] <= arr[i]) {
                for (int j = idx+1; j < i; j++) {
                    res += arr[idx]-arr[j];
                }
                idx = i;
            }
        }
        int idx2 = w-1;
        for (int i = w-2; i >= idx; i--) {
            if (arr[i] >= arr[idx2]) {
                for (int j = idx2-1; j > i; j--) {
                    res += arr[idx2]-arr[j];
                }
                idx2 = i;
            }
        }
        System.out.println(res);
    }
}
