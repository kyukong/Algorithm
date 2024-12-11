import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int K;
    private static int[] days;
    private static int result = -Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        days = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            days[i] = Integer.parseInt(st.nextToken());
        }

        twoPointer();
        System.out.println(result);
    }

    private static void twoPointer() {
        int left = 0, right = left + K - 1;

        while (right < N) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += days[i];
            }
            result = Math.max(result, sum);

            left++;
            right++;
        }
    }
}