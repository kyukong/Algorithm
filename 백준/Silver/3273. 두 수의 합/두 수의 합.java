import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[] array;
    private static int x;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        x = Integer.parseInt(br.readLine());

        twoPointer();
        System.out.println(result);
    }

    private static void twoPointer() {
        int left = 0, right = n - 1;

        while (left < right) {
            int sum = array[left] + array[right];
            if (sum < x) {
                left++;
            } else if (sum > x) {
                right--;
            } else {
                result++;
                left++;
            }
        }
    }
}