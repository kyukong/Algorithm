import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int D;
    private static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        nodes = new Node[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(start, end, weight);
        }

        int[] distance = dijkstra();
        System.out.println(distance[D]);
    }

    private static int[] dijkstra() {
        // 0 부터 index km 까지의 거리
        int[] distance = new int[D + 1];
        for (int i = 0; i <= D; i++) {
            distance[i] = i;
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(0,0, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (Node next : nodes) {
                // 현재위치 기준 앞에 있는 경우만 확인
                if (next.start < current.end || next.end > D) {
                    continue;
                }
                // 다음 지점의 최솟값 갱신 = 현재까지의 최솟값 + 현재부터 다음 지점까지의 거리 + 다음 지점의 가중치
                int cost = distance[current.end] + (next.start - current.end) + next.weight;
                if (cost < distance[next.end]) {
                    distance[next.end] = cost;
                    queue.offer(new Node(current.end, next.end, distance[next.end]));
                }
            }
            // 현재까지의 최솟값 + 남은 거리의 합으로 갱신
            distance[D] = Math.min(distance[D], distance[current.end] + (D - current.end));
        }
        return distance;
    }

    public static class Node implements Comparable<Node> {

        int start;
        int end;
        int weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return this.weight - other.weight;
        }
    }
}