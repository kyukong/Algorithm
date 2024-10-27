import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[Math.max(n + 1, 4)];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        System.out.println(minimum(n));
    }

    private static int minimum(int num) {
        if (dp[num] == Integer.MAX_VALUE) {
            if (num % 3 == 0) {
                dp[num] = Math.min(dp[num], minimum(num / 3) + 1);
            }
            if (num % 2 == 0) {
                dp[num] = Math.min(dp[num], minimum(num / 2) + 1);
            }
            if (dp[num] > 1) {
                dp[num] = Math.min(dp[num], minimum(num - 1) + 1);
            }
        }
        return dp[num];
    }
}