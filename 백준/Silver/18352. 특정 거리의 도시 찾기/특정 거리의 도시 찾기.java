import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int K;
    private static int X;
    private static List<List<Integer>> bridge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;
        bridge = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            bridge.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            bridge.get(start).add(end);
        }

        List<Integer> result = new ArrayList<>();
        int[] distance = dijkstra(X);

        for (int i = 0; i < N; i++) {
            if (distance[i] != K) {
                continue;
            }
            result.add(i + 1);
        }

        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result);
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
            }
        }
    }

    private static int[] dijkstra(int start) {
        int[] distance = new int[N];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(start);

        for (int i = 0; i < N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int j = 0; j < bridge.get(current).size(); j++) {
                int next = bridge.get(current).get(j);
                int cost = distance[current] + 1;
                if (cost < distance[next]) {
                    distance[next] = cost;
                    queue.offer(next);
                }
            }
        }

        return distance;
    }
}