import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] t = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            t[i] = Integer.parseInt(st.nextToken());
        }

        long result = 0;
        int start = 0;
        int end = start + m - 1;
        while (end < n) {
            long profit = 0;
            for (int i = start; i <= end; i++) {
                profit += t[i];
            }
            result = Math.max(result, profit);

            start++;
            end++;
        }

        System.out.println(result);
    }
}