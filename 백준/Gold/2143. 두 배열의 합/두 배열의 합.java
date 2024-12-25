import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static long T;
    private static int n;
    private static int[] A;
    private static int m;
    private static int[] B;

    private static Map<Long, Long> aCount = new HashMap<>();
    private static long result = 0L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Long.parseLong(br.readLine());

        n = Integer.parseInt(br.readLine());
        A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // A 배열에 나올 수 있는 합 경우의 수 카운트
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                long count = aCount.getOrDefault(sum, 0L);
                aCount.put(sum, ++count);
            }
        }

        // B 배열에 나올 수 있는 합 경우의 수 카운트
        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                long count = aCount.getOrDefault(T - sum, 0L);
                result += count;
            }
        }

        System.out.println(result);
    }
}