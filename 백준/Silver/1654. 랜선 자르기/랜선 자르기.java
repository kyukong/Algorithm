import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int K;
    private static int N;
    private static long[] array;
    private static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        array = new long[K];

        for (int i = 0; i < K; i++) {
            array[i] = Long.parseLong(br.readLine());
        }

        long min = 1, max = (long) Math.pow(2, 31) - 1;
        while (min <= max) {
            long mid = (min + max) / 2;

            long count = 0;
            for (int i = 0; i < K; i++) {
                count += array[i] / mid;
            }

            if (count >= N) {
                result = Math.max(result, mid);
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(result);
    }
}