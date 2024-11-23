import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int[] lights;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        lights = new int[M];
        for (int i = 0; i < M; i++) {
            lights[i] = Integer.parseInt(st.nextToken());
        }

        // 가장 첫번째, 마지막 가로등 위치 설정
        if (M == 1) {
            int distance = Math.max(lights[0], N - lights[0]);
            answer = Math.max(answer, distance);
        } else {
            answer = Math.max(answer, lights[0]);
            answer = Math.max(answer, N - lights[M - 1]);
        }

        // 중간 가로등 위치 설정
        for (int i = 0; i < M - 1; i++) {
            answer = Math.max(answer, (lights[i + 1] + 1 - lights[i]) / 2);
        }

        System.out.println(answer);
    }
}