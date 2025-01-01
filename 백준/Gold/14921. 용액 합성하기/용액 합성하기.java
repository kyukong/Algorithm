import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[] array;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = N - 1;
        while (left < right) {
            int sum = array[left] + array[right];
            if (Math.abs(result) > Math.abs(sum)) {
                result = sum;
            }

            if (sum >= 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(result);
    }
}