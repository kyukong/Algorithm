import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static char[][] board;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];

        String row;
        for (int n = 0; n < N; n++) {
            row = br.readLine();
            for (int m = 0; m < M; m++) {
                board[n][m] = row.charAt(m);
            }
        }

        for (int y = 0; y < N - 7; y++) {
            for (int x = 0; x < M - 7; x++) {
                char[][] cropBoard = generate(x, x + 7, y, y + 7);
                result = Math.min(result, countMap('W', cropBoard));
                result = Math.min(result, countMap('B', cropBoard));
            }
        }

        System.out.println(result);
    }

    // 8 X 8 크기의 체스판 생성
    private static char[][] generate(int x1, int x2, int y1, int y2) {
        char[][] crop = new char[8][8];
        int x;
        int newX;
        int newY = 0;
        for (int y = y1; y <= y2; y++, newY++) {
            for (x = x1, newX = 0; x <= x2; x++, newX++) {
                crop[newY][newX] = board[y][x];
            }
        }
        return crop;
    }

    // 체스판 색상 조합에서 다시 칠해야 하는 개수 카운트
    private static int countMap(char startColor, char[][] map) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            count += countRow(startColor, map[i]);
            startColor = convertColor(startColor);
        }
        return count;
    }

    // 한 줄에 해당하는 체스판 색상 조합에서 다시 칠해야 하는 개수 카운트
    private static int countRow(char startColor, char[] row) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (row[i] != startColor) {
                count++;
            }
            startColor = convertColor(startColor);
        }
        return count;
    }

    // 색상 전환
    private static char convertColor(char color) {
        if (color == 'W') {
            return 'B';
        }
        return 'W';
    }
}