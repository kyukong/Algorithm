import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int[] a;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        twoPointer();
        System.out.println(result);
    }

    private static void twoPointer() {
        int left = 0, right = 0;

        while (left < N && right < N) {
            long sum = 0;
            for (int i = left; i <= right; i++) {
                sum += a[i];
            }

            if (sum > M) {
                left++;
            } else if (sum < M) {
                right++;
            } else {
                result++;
                left++;
            }
        }
    }
}