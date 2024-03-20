import java.util.*;

class Solution {
    
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    private int[][] map = new int[101][101];
    private int[][] visited = new int[101][101];
    private int[][] rectangle;
    private int characterX;
    private int characterY;
    private int itemX;
    private int itemY;
    private int result = Integer.MAX_VALUE;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        this.rectangle = rectangle;
        this.characterX = characterX * 2;
        this.characterY = characterY * 2;
        this.itemX = itemX * 2;
        this.itemY = itemY * 2;
        
        // rectangle 값 모두 2배로 변경
        for (int[] rect : rectangle) {
            for (int i = 0; i < 4; i++) {
                rect[i] *= 2;
            }
        }
        
        // 테두리는 1 로 채우기
        for (int[] rect : rectangle) {
            // 아래 & 위
            for (int i = rect[0]; i <= rect[2]; i++) {
                map[rect[1]][i] = 1;
                map[rect[3]][i] = 1;
            }
            
            // 왼쪽 & 오른쪽
            for (int i = rect[1]; i <= rect[3]; i++) {
                map[i][rect[0]] = 1;
                map[i][rect[2]] = 1;
            }
        }
        
        // 도형 내부는 0 으로 채우기
        for (int[] rect : rectangle) {
            for (int y = rect[1] + 1; y <= rect[3] - 1; y++) {
                for (int x = rect[0] + 1; x <= rect[2] - 1; x++) {
                    map[y][x] = 0;
                }
            }
        }
        
        bfs();
        
        return map[itemY * 2][itemX * 2] / 2;
    }
    
    private void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {characterX, characterY});
        visited[characterY][characterX] = 1;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == itemX && now[1] == itemY) {
                break;
            }
            
            for (int[] direction : directions) {
                int nextX = now[0] + direction[0];
                int nextY = now[1] + direction[1];
                
                if (nextX < 0 || nextY < 0 || nextX > 100 || nextY > 100) {
                    continue;
                }
                if (map[nextY][nextX] != 1 || visited[nextY][nextX] == 1) {
                    continue;
                }
                map[nextY][nextX] = map[now[1]][now[0]] + 1;
                q.offer(new int[] {nextX, nextY});
                visited[nextY][nextX] = 1;
            }
        }
    }
}