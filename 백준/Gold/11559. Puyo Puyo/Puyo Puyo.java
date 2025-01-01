import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    private static final int column = 6;
    private static final int row = 12;
    private static final int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static final char[][] board = new char[row][column];

    private static int bomb = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < row; i++) {
            char[] rows = br.readLine().toCharArray();
            for (int j = 0; j < column; j++) {
                board[i][j] = rows[j];
            }
        }

        while (true) {
            // 연쇄
            boolean exist = chain();
            if (!exist) {
                break;
            }
            bomb++;

            // 이동
            move();
        }

        System.out.println(bomb);
    }

    private static boolean chain() {
        boolean exist = false;
        int[][] visited = new int[row][column];
        Queue<int[]> queue = new LinkedList<>();

        for (int x = 0; x < column; x++) {
            for (int y = 0; y < row; y++) {
                if (board[y][x] == '.' || visited[y][x] == 1) {
                    continue;
                }

                int count = 1;
                queue.offer(new int[] {x, y});

                List<int[]> candidates = new ArrayList<>();
                candidates.add(new int[] {x, y});
                while (!queue.isEmpty()) {
                    int[] point = queue.poll();
                    visited[y][x] = 1;

                    for (int[] direction : direction) {
                        int nextX = point[0] + direction[0];
                        int nextY = point[1] + direction[1];

                        if (nextX < 0 || nextY < 0 || nextX >= column || nextY >= row) {
                            continue;
                        }
                        if (board[nextY][nextX] == '.' || visited[nextY][nextX] == 1) {
                            continue;
                        }
                        if (board[y][x] != board[nextY][nextX]) {
                            continue;
                        }
                        count++;
                        visited[nextY][nextX] = 1;

                        queue.offer(new int[] {nextX, nextY});
                        candidates.add(new int[] {nextX, nextY});
                    }
                }

                if (count >= 4) {
                    exist = true;
                    for (int[] candidate : candidates) {
                        board[candidate[1]][candidate[0]] = '.';
                    }
                }
            }
        }

        return exist;
    }

    private static void move() {
        for (int i = 0; i < column; i++) {
            int y = row - 1;
            while (y >= 0) {
                // 공백 카운트
                int count = 0;
                for (int j = y; j >= 0; j--) {
                    if (board[j][i] != '.') {
                        break;
                    }
                    count++;
                }

                // 뿌요 옮기기
                int moving = count;
                int k = y;
                while (moving > 0 && k - count >= 0) {
                    board[k][i] = board[k - count][i];
                    board[k - count][i] = '.';

                    k--;
                    moving--;
                }

                y--;
            }
        }
    }
}