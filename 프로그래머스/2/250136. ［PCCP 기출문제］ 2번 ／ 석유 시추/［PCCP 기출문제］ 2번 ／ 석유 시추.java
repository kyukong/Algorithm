import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private int[][] land;
    private int height; // n
    private int width; // m
    private int[] oil;
    private int[][] visited;

    public int solution(int[][] land) {
        this.land = land;
        this.height = land.length;
        this.width = land[0].length;
        this.oil = new int[width];
        this.visited = new int[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (visited[y][x] == 1 || land[y][x] == 0) {
                    continue;
                }
                bfs(x, y);
            }
        }

        int result = 0;
        for (int i = 0; i < width; i++) {
            result = Math.max(result, oil[i]);
        }
        return result;
    }

    private void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[y][x] = 1;

        int sum = 1, minX = x, maxX = x;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int[] next : new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}) {
                int nextX = now[0] + next[0];
                int nextY = now[1] + next[1];

                if (nextX < 0 || nextY < 0 || nextX >= width || nextY >= height) {
                    continue;
                }
                if (visited[nextY][nextX] == 1 || land[nextY][nextX] == 0) {
                    continue;
                }

                visited[nextY][nextX] = 1;
                queue.offer(new int[] {nextX, nextY});

                sum += 1;
                minX = Math.min(minX, nextX);
                maxX = Math.max(maxX, nextX);
            }
        }

        // 현재 석유 범위에 속하는 경우
        for (int nowX = minX; nowX <= maxX; nowX++) {
            oil[nowX] += sum;
        }
    }
}