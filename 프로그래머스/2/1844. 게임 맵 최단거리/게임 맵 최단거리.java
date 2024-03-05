import java.util.*;

class Solution {
    
    private static final int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // x, y
    
    private int[][] maps;
    private int[][] visited;
    private int width;
    private int height;
    
    public int solution(int[][] maps) {
        this.maps = maps;
        this.width = maps[0].length; // x
        this.height = maps.length; // y
        this.visited = new int[height][width];
        
        bfs();
        
        if (visited[height - 1][width - 1] == 0) {
            return -1;
        }
        return visited[height - 1][width - 1];
    }
    
    private void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0}); // x, y
        visited[0][0] = 1;
        
        while (!q.isEmpty()) {
            int[] point = q.poll();
            
            if (point[0] == height - 1 && point[1] == width - 1) {
                break;
            }
            
            for (int[] direction : directions) {
                int nextX = point[0] + direction[0];
                int nextY = point[1] + direction[1];
                
                if (nextX < 0 || nextY < 0 || nextX >= width || nextY >= height) {
                    continue;
                }
                if (maps[nextY][nextX] == 0) {
                    continue;
                }
                if (visited[nextY][nextX] != 0) {
                    continue;
                }
                q.offer(new int[] {nextX, nextY});
                visited[nextY][nextX] = visited[point[1]][point[0]] + 1;
            }
        }
    }
}