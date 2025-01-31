import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = Integer.MAX_VALUE;

    private static int N;
    private static int M;
    private static int[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new int[N][N];

        // 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                array[i][j] = INF;
                array[j][i] = INF;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            array[start][end] = 1;
            array[end][start] = 1;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (array[i][k] == INF || array[k][j] == INF) {
                        continue;
                    }
                    array[i][j] = Math.min(array[i][j], array[i][k] + array[k][j]);
                }
            }
        }

        // 결과
        int number = 0; // 사람의 번호
        int min = INF; // 연결 최솟값

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += array[i][j];
            }

            if (min > sum) {
                min = sum;
                number = i + 1;
            } else if (min == sum) {
                number = Math.min(number, i + 1);
            }
        }

        System.out.println(number);
    }
}