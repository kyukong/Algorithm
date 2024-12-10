import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[] n;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        n = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            n[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(n); // 이진탐색을 위한 오름차순 정렬

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            System.out.println(binary(Integer.parseInt(st.nextToken())));
        }
    }

    private static int binary(int num) {
        int left = 0, right = N - 1;
        while (left <= right) {
            int mid = (int) Math.floor((double) (right + left) / 2);
            if (num == n[mid]) {
                return 1;
            } else if (num > n[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }
}