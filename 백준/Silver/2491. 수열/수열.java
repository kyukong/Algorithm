import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[] numbers;
    private static int result = 0;

    private static int[] asc;
    private static int[] desc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i]= Integer.parseInt(st.nextToken());
        }

        asc();
        desc();

        System.out.println(result);
    }

    private static void asc() {
        asc = new int[n];

        for (int i = 0; i < n; i++) {
            asc[i] = 1;
            if (i != 0) {
                if (numbers[i] >= numbers[i - 1]) {
                    asc[i] = Math.max(asc[i], asc[i - 1] + 1);
                }
            }
            result = Math.max(result, asc[i]);
        }
    }

    private static void desc() {
        desc = new int[n];

        for (int i = 0; i < n; i++) {
            desc[i] = 1;
            if (i != 0) {
                if (numbers[i] <= numbers[i - 1]) {
                    desc[i] = Math.max(desc[i], desc[i - 1] + 1);
                }
            }
            result = Math.max(result, desc[i]);
        }
    }
}