import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static long[] array;
    private static long first;
    private static long second;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        array = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Long.parseLong(st.nextToken());
        }

        twoPointer();
        System.out.printf("%d %d\n", first, second);
    }

    private static void twoPointer() {
        int left = 0, right = N - 1;
        long result = Long.MAX_VALUE;

        while (left < right) {
            long diff = array[left] + array[right];
            if (Math.abs(diff) < result) {
                result = Math.abs(diff);
                first = array[left];
                second = array[right];
            }

            if (diff > 0) {
                right--;
            } else if (diff < 0) {
                left++;
            } else {
                break;
            }
        }
    }
}