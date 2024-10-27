import java.io.*;

public class Main {

    private static final int[] dp = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int t = 0; t < testcase; t++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(sum(n));
        }
    }

    private static int sum(int n) {
        if (dp[n] == 0) {
            dp[n] = sum(n - 1) + sum(n - 2) + sum(n - 3);
        }
        return dp[n];
    }
}