import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] distance = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                distance[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            distance[start][end] = 1;
            distance[end][start] = 1;
        }

        // 플로이드 워셜
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distance[i][k] == INF || distance[k][j] == INF) {
                        continue;
                    }
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        PriorityQueue<Place> queue = new PriorityQueue<>();
        for (int first = 0; first < n; first++) {
            for (int second = 0; second < n; second++) {
                if (first == second) {
                    continue;
                }
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    sum += Math.min(distance[k][first], distance[k][second]);
                }
                queue.offer(new Place(first + 1, second + 1, sum * 2));
            }
        }

        System.out.println(queue.poll());
    }

    static class Place implements Comparable<Place> {

        int first;
        int second;
        int total;

        public Place(int first, int second, int total) {
            this.first = first;
            this.second = second;
            this.total = total;
        }

        @Override
        public int compareTo(Place other) {
            if (this.total != other.total) {
                return this.total - other.total;
            }
            if (this.first != other.first) {
                return this.first - other.first;
            }
            return this.second - other.second;
        }

        @Override
        public String toString() {
            return first + " " + second + " " + total;
        }
    }
}