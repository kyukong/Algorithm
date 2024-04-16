import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    private static final List<Integer> peoples = new ArrayList<>();

    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            peoples.add(Integer.parseInt(st.nextToken()));
        }

        // 오름차순 정렬
        peoples.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Objects.equals(o1, o2)) {
                    return 0;
                }
                return o1 - o2;
            }
        });

        for (int i = 0; i < n; i++) {
            result += peoples.get(i) * (n - i);
        }

        System.out.println(result);
    }
}