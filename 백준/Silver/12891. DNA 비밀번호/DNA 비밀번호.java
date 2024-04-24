import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String[] dna = new String[s];
        String[] strings = st.nextToken().split("");
        int[] count = new int[4]; // A C G T
        for (int i = 0; i < s; i++) {
            dna[i] = strings[i];
            if (i < p) {
                count[position(dna[i])]++;
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] check = new int[4];
        for (int i = 0; i < 4; i++) {
            check[i] = Integer.parseInt(st.nextToken());
        }

        int end = p - 1;
        int result = 0;
        for (int start = 0; start <= s - p; start++, end++) {
            boolean isPossible = true;
            for (int i = 0; i < 4; i++) {
                if (check[i] > count[i]) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                result++;
            }

            if (end + 1 >= s) {
                break;
            }

            count[position(dna[start])]--;
            count[position(dna[end + 1])]++;
        }

        System.out.println(result);
    }

    private static int position(String dna) {
        switch (dna) {
            case "A":
                return 0;
            case "C":
                return 1;
            case "G":
                return 2;
            case "T":
                return 3;
        }
        return 0;
    }
}