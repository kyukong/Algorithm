import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testcase = Integer.parseInt(st.nextToken());

        for (int t = 0; t < testcase; t++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long result = 1;

            while (true) {
                int n = Math.min(a, b);
                boolean available = false;

                for (int i = 2; i <= n; i++) {
                    if (a % i == 0 && b % i == 0) {
                        result *= i;
                        a = a / i;
                        b = b / i;
                        available = true;

                        break;
                    }
                }

                if (!available) {
                    result *= a;
                    result *= b;
                    break;
                }
            }

            System.out.println(result);
        }
    }
}