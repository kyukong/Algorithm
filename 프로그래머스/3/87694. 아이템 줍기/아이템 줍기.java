import java.util.*;

class Solution {
    
    private static final int[][] directions
        = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private static final int SIZE = 102;
    
    private int[][] board = new int[SIZE][SIZE];
    private int[][] visited = new int[SIZE][SIZE];
    private int[][] map = new int[SIZE][SIZE];
    
    private int[][] rectangle;
    private int characterX;
    private int characterY;
    private int itemX;
    private int itemY;
    
    private int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] rectangle, 
                        int characterX, int characterY, 
                        int itemX, int itemY) {
        this.rectangle = rectangle;
        this.characterX = characterX * 2;
        this.characterY = characterY * 2;
        this.itemX = itemX * 2;
        this.itemY = itemY * 2;
        
        fill();
        bfs();
        
        return map[this.itemY][this.itemX] / 2;
    }
    
    private void fill() {
        for (int[] point : rectangle) {
            int leftX = point[0] * 2;
            int leftY = point[1] * 2;
            int rightX = point[2] * 2;
            int rightY = point[3] * 2;
            
            for (int y = leftY; y <= rightY; y++) {
                for (int x = leftX; x <= rightX; x++) {
                    int color = 2;
                    if (y == leftY || y == rightY
                        || x == leftX || x == rightX) {
                        color = 1;
                    }
                    
                    // 선: 1, 내부: 2
                    board[y][x] = Math.max(board[y][x], color);
                }
            }
        }
    }
    
    private void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {characterY, characterX});
        
        visited[characterY][characterX] = 1;
        map[characterY][characterX] = 1;
        
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            if (point[1] == itemX && point[0] == itemY) {
                break;
            }
            
            for (int[] direction : directions) {
                int nextX = point[1] + direction[1];
                int nextY = point[0] + direction[0];
                
                if (nextX < 0 || nextX >= SIZE || nextY < 0 || nextY >= SIZE) {
                    continue;
                }
                if (board[nextY][nextX] != 1 || visited[nextY][nextX] == 1) {
                    continue;
                }
                map[nextY][nextX] = map[point[0]][point[1]] + 1;
                queue.offer(new int[] {nextY, nextX});
                visited[nextY][nextX] = 1;
            }
        }
    }
}