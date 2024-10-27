import java.io.*;

public class Main {

    private static int n;
    private static long[] dp = new long[91];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        dp[0] = 0L;
        dp[1] = 1L;

        System.out.println(fibonacci(n));
    }

    private static long fibonacci(int num) {
        if (num == 0 || num == 1) {
            return dp[num];
        }
        if (dp[num] == 0) {
            dp[num] = fibonacci(num - 1) + fibonacci(num - 2);
        }
        return dp[num];
    }
}