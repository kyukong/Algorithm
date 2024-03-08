import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[][] weights;
    private static int[] visited;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        weights = new int[n][n];
        visited = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                weights[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            visited[i] = 1;
            dfs(i, i, 0, 0);
            visited[i] = 0;
        }

        System.out.println(result);
    }

    private static void dfs(int start, int now, int total, int count) {
        if (count >= n - 1) {
            if (weights[now][start] != 0) {
                result = Math.min(result, total + weights[now][start]);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (weights[now][i] == 0 || visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            dfs(start, i, total + weights[now][i], count + 1);
            visited[i] = 0;
        }
    }
}