import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<Node>[] map;
    private static int[] visit;
    private static int n;
    private static int m;
    private static int max;

    static class Node {
        int next;
        int dist;

        public Node(int next, int dist) {
            this.next = next;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new ArrayList[n];
        visit = new int[n];

        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            map[a].add(new Node(b, d));
            map[b].add(new Node(a, d));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            dfs(a, b, 0);
            System.out.println(max);

            max = 0;
            visit = new int[n];
        }
    }

    private static void dfs(int start, int end, int dist) {
        if (start == end) {
            max = dist;
            return;
        }

        visit[start] = 1;
        for (int i = 0; i < map[start].size(); i++) {
            if (visit[map[start].get(i).next] == 0) {
                dfs(map[start].get(i).next, end, dist + map[start].get(i).dist);
            }
        }
    }
}