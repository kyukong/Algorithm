import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int C;
    private static int[] points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        points = new int[N];

        for (int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(points);

        System.out.println(binarySearch());
    }

    private static int binarySearch() {
        int low = 1, high = points[N - 1] - points[0] + 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low - 1;
    }

    private static boolean isPossible(int width) {
        int count = 1; // 공유기 설치 개수
        int setting = 0; // 이전에 설치한 공유기 인덱스

        for (int i = 1; i < points.length; i++) {
            if (points[i] - points[setting] >= width) {
                count++;
                setting = i;
            }
        }
        return count >= C;
    }
}