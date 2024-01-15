import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int width;
    private static int height;
    private static int[] numbers;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        numbers = new int[width];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < width; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int h = 1; h <= height; h++) {
            int start = 0;

            // start 지점 찾기
            boolean test = false;
            while (start < width) {
                if (h <= numbers[start]) {
                    test = true;
                    break;
                }
                start++;
            }
            if (!test) {
                continue;
            }

            // end 지점 찾기
            int end = start + 1;
            while (start < width && end < width) {
                // 다음 벽 높이 계산
                if (h > numbers[end]) {
                    end++;
                    continue;
                }

                // 빗물 계산
                for (int i = start + 1; i < end; i++) {
                    result++;
                }

                // 시작점 갱신
                start = end;
                end++;
            }
        }

        System.out.println(result);
    }
}