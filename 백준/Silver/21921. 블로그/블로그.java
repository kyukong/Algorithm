import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int X;
    private static int[] array;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        array = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // 구간합 구하기
        int sum = 0;
        for (int i = 0; i < X; i++) {
            sum += array[i];
        }

        // 슬라이딩 윈도우
        int left = 0, right = X - 1;
        int count = 0;
        while (left <= N - 1 && right <= N - 1) {
            if (result < sum) {
                result = sum;
                count = 1;
            } else if (result == sum) {
                count++;
            }

            sum -= array[left++];
            right++;
            if (right >= N) {
                break;
            }
            sum += array[right];
        }

        if (result == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(result);
            System.out.println(count);
        }
    }
}