import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static long S;
    private static int[] array;
    private static long result = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        array = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0;
        long sum = array[0];
        while (left <= right) {
            if (sum >= S) {
                result = Math.min(result, right - left + 1);
                sum -= array[left++];
            } else {
                right++;
                if (right >= N) {
                    break;
                }
                sum += array[right];
            }
        }

        if (result == Long.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}