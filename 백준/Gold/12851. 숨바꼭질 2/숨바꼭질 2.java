import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] visited = new int[100_002];

    private static int N;
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        // 시작 지점을 1칸 이동으로 취급
        visited[N] = 1;

        int result = Integer.MAX_VALUE;
        int count = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == K) {
                if (visited[K] - 1 < result) {
                    result = visited[K] - 1;
                    count = 1;
                } else if (visited[K] - 1 == result) {
                    count++;
                }
            }

            for (int next : new int[] {now - 1, now + 1, now * 2}) {
                if (next < 0 || next >= visited.length - 1) {
                    continue;
                }
                if (visited[next] != 0 && visited[next] != visited[now] + 1) {
                    continue;
                }

                visited[next] = visited[now] + 1;
                queue.offer(next);
            }
        }

        System.out.println(result);
        System.out.println(count);
    }
}