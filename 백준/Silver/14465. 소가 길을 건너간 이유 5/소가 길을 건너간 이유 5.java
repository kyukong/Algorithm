import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int K;
    private static int B;
    private static int[] array;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        array = new int[N];

        for (int i = 0; i < B; i++) {
            int num = Integer.parseInt(br.readLine());
            array[num - 1] = 1;
        }

        // 최초 구역의 고장난 신호등 확인
        int broken = 0;
        for (int i = 0; i < K; i++) {
            if (array[i] == 1) {
                broken++;
            }
        }

        // 구역 옮겨가며 최소 개수 찾기
        int left = 0, right = K - 1;
        while (left <= N - 1 && right <= N - 1) {
            result = Math.min(result, broken);

            if (array[left++] == 1) {
                broken--;
            }

            right++;
            if (right >= N) {
                break;
            }
            if (array[right] == 1) {
                broken++;
            }
        }

        System.out.println(result);
    }
}