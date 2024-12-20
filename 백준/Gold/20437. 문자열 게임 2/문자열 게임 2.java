import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String W;
            int K;

            W = br.readLine();
            K = Integer.parseInt(br.readLine());

            int min = Integer.MAX_VALUE;
            int max = -1;

            if (K == 1) {
                System.out.println("1 1");
                continue;
            }

            int[] alpha = new int[26];
            for (int i = 0; i < W.length(); i++) {
                alpha[W.charAt(i) - 'a']++;
            }

            for (int i = 0; i < W.length(); i++) {
                if (alpha[W.charAt(i) - 'a'] < K) {
                    continue;
                }

                int count = 1;
                for (int j = i + 1; j < W.length(); j++) {
                    if (W.charAt(i) == W.charAt(j)) {
                        count++;
                    }

                    if (count == K) {
                        min = Math.min(min, j - i + 1);
                        max = Math.max(max, j - i + 1);
                        break;
                    }
                }
            }

            if (min == Integer.MAX_VALUE) {
                System.out.println("-1");
            } else {
                System.out.printf("%d %d%n", min, max);
            }
        }
    }
}