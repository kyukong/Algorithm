import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        double z = ((double)(y * 100) / x);
        z = Math.floor(z);


        if (z >= 99) {
            System.out.println(-1);
            return;
        }

        z += 1;

        double a = (z * x - 100 * y) / (100 - z);
        System.out.println((int) Math.ceil(a));
    }
}