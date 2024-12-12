import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int K;
    private static int[][] board;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));
            }
        }

        int row = 0;
        while (row < N) {
            int left = 0, right = left + K - 1;

            while (right < M) {
                boolean possible = true;
                for (int i = left; i <= right; i++) {
                    if (board[row][i] == 1) {
                        possible = false;
                        break;
                    }
                }

                if (possible) {
                    result++;
                }
                left++;
                right++;
            }
            row++;
        }

        System.out.println(result);
    }
}