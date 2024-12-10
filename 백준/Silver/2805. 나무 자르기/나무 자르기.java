import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int[] trees;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        binary();
        System.out.println(result);
    }

    private static void binary() {
        int low = 0, high = 1_000_000_000, height;

        while (low <= high) {
            height = (int) Math.floor((double) (low + high) / 2);

            if (sum(height) >= M) {
                result = Math.max(result, height);
                low = height + 1;
            } else {
                high = height - 1;
            }
        }
    }

    private static long sum(int height) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (height >= trees[i]) {
                continue;
            }
            sum += trees[i] - height;
        }
        return sum;
    }
}