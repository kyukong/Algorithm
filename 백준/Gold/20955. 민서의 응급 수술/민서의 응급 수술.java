import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static final Map<Integer, Set<Integer>> connections = new HashMap<>();

    private static int[] visited;
    private static int N;
    private static int M;
    private static int node;
    private static int bridge;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[N];

        // 1. Map 자료구조 이용하여 연결 구조 나타내기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;

            Set<Integer> conn1 = connections.getOrDefault(u, new HashSet<>());
            Set<Integer> conn2 = connections.getOrDefault(v, new HashSet<>());

            conn1.add(v);
            conn2.add(u);
            connections.put(u, conn1);
            connections.put(v, conn2);
        }

        // 2. 중복으로 이어진 스냅스 제거
        int total = 0;
        for (Set<Integer> snaps : connections.values()) {
            total += snaps.size();
        }
        result += M - total / 2;

        // 3. 영역 개수 찾기 (dfs)
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                node = 0;
                bridge = 0;
                dfs(i);
                result++; // 영역 개수 카운트
                result += Math.abs((node - 1) - bridge / 2); // 사이클 제거
            }
        }

        // 4. 결과 출력
        System.out.println(result - 1);
    }

    private static void dfs(int now) {
        visited[now] = 1;

        Set<Integer> conn = connections.getOrDefault(now, new HashSet<>());
        node++;
        bridge += conn.size();

        for (int next : conn) {
            if (visited[next] == 0) {
                dfs(next);
            }
        }
    }
}