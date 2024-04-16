import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final List<Long> nums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            nums.add(Long.parseLong(br.readLine()));
        }

        // 오름차순 정렬
        nums.sort(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return (int)(o1 - o2);
            }
        });

        // 차이 계산
        long result = Integer.MAX_VALUE;
        int left = 0;
        int right = left + 1;

        while (right < N && left < N - 1) {
            if (left >= right) {
                right++;
                continue;
            }
            long diff = nums.get(right) - nums.get(left);
            if (diff >= M) {
                left++;
                result = Math.min(result, diff);
            } else {
                right++;
            }
        }

        System.out.println(result);
    }
}