import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int[][] sea;
    private static int size = 2;
    private static int seconds = 0;
    private static int eat = 0;

    private static int distance = 0;
    private static int[] none = new int[] {-1, -1};
    private static int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static class Node implements Comparable<Node> {

        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node other) {
            if (y > other.y) {
                return 1;
            } else if (y < other.y) {
                return -1;
            }

            if (x > other.x) {
                return 1;
            } else if (x < other.x) {
                return -1;
            }
            return 0;
        }

        public int[] getArray() {
            return new int[] {x, y};
        }
    }

    private static class Nodes {

        int minDistance = Integer.MAX_VALUE;
        List<Node> value = new ArrayList<>();

        public void add(Node node, int distance) {
            if (distance > minDistance) {
                return;
            } else if (distance < minDistance) {
                minDistance = distance;
                value.clear();
            }
            value.add(node);
        }

        public int[] shortest() {
            if (value.isEmpty()) {
                return none;
            }
            Collections.sort(value);
            distance = minDistance;
            return value.get(0).getArray();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        sea = new int[n][n];

        // 배열 및 시작 지점 초기화
        int[] start = new int[2];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                int number = Integer.parseInt(st.nextToken());
                sea[y][x] = number;
                if (number == 9) {
                    start[0] = x;
                    start[1] = y;
                }
            }
        }

        // 물고기 식사
        eat(start);

        System.out.println(seconds);
    }

    private static void eat(int[] now) {
        int [] fish = shortest(now);
        if (fish == none) {
            return;
        }

        seconds += distance;
        eat++;
        if (eat == size) {
            size++;
            eat = 0;
        }

        sea[now[1]][now[0]] = 0;
        sea[fish[1]][fish[0]] = 9;

        eat(fish);
    }

    private static int[] shortest(int[] shark) {
        Nodes nodes = new Nodes();
        int[][] visited = new int[n][n];
        visited[shark[1]][shark[0]] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(shark);

        int nextX, nextY;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            for (int[] direction : directions) {
                nextX = point[0] + direction[0];
                nextY = point[1] + direction[1];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) {
                    continue;
                }
                if (visited[nextY][nextX] > 0) {
                    continue;
                }
                if (sea[nextY][nextX] != 9 && sea[nextY][nextX] > size) {
                    continue;
                }
                visited[nextY][nextX] = visited[point[1]][point[0]] + 1;
                if (sea[nextY][nextX] != 0 && sea[nextY][nextX] < size) {
                    nodes.add(new Node(nextX, nextY), visited[nextY][nextX] - 1);
                }
                queue.add(new int[] {nextX, nextY});
            }
        }
        return nodes.shortest();
    }
}