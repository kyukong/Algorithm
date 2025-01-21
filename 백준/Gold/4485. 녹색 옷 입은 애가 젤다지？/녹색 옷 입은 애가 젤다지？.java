import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[][] board;
    private static int[][] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                return;
            }

            board = new int[N][N];
            score = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    score[i][j] = Integer.MAX_VALUE;
                }
            }

            bfs(0, 0);

            System.out.printf("Problem %d: %d\n", count++, score[N - 1][N - 1]);
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        score[0][0] = board[0][0];

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int[] direction : new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}) {
                int nextX = now[0] + direction[0];
                int nextY = now[1] + direction[1];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                    continue;
                }

                int weight = score[now[1]][now[0]] + board[nextY][nextX];
                if (weight >= score[nextY][nextX]) {
                    continue;
                }

                score[nextY][nextX] = weight;
                queue.offer(new int[] {nextX, nextY});
            }
        }
    }
}