import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static List<List<int[]>> board = new ArrayList<>();
    private static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 초기화
        for (int i = 0; i < N; i++) {
            board.add(new ArrayList<>());
        }
        distance = new int[N];
        for (int i = 0; i < N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());

            board.get(start).add(new int[] {end, weight});
            board.get(end).add(new int[] {start, weight});
        }

        dijkstra();

        System.out.println(distance[N - 1]);
    }

    private static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(0, 0));
        distance[0] = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int[] info : board.get(now.end)) {
                int next = info[0];
                int weight = info[1];
                if (weight == Integer.MAX_VALUE) {
                    continue;
                }
                int cost = distance[now.end] + weight;
                if (distance[next] > cost) {
                    distance[next] = cost;
                    queue.offer(new Node(next, weight));
                }
            }
        }
    }

    public static class Node implements Comparable<Node> {

        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return this.weight - other.weight;
        }
    }
}