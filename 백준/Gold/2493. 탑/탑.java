import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static Stack<Top> stack = new Stack<>();
    private static StringBuilder sb = new StringBuilder();

    private static class Top {

        int height;
        int num;

        public Top(int height, int num) {
            this.height = height;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        int nowHeight;
        Top prior;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nowHeight = Integer.parseInt(st.nextToken());

            if (stack.empty()) {
                stack.push(new Top(nowHeight, i + 1));
                sb.append(0).append(" ");
                continue;
            }

            prior = stack.peek();
            // 이전의 값이 더 큰 경우
            //  - 이전의 값 높이 저장 및 현재 위치 스택에 저장
            if (prior.height > nowHeight) {
                stack.push(new Top(nowHeight, i + 1));
                sb.append(prior.num).append(" ");
            }
            // 현재의 값이 더 크거나 같은 경우
            //  - 더 큰 값을 찾을 때까지 pop() -> 어차피 이후의 값이 현재 위치에 도달할 것이므로 이전의 작은 값이 필요 없음
            //  - 현재의 값 스택에 저장
            else {
                while (true) {
                    if (stack.empty()) {
                        stack.push(new Top(nowHeight, i + 1));
                        sb.append(0).append(" ");
                        break;
                    }
                    prior = stack.peek();

                    if (prior.height > nowHeight) {
                        stack.push(new Top(nowHeight, i + 1));
                        sb.append(prior.num).append(" ");
                        break;
                    }

                    stack.pop();
                }
            }
        }
        System.out.println(sb);
    }
}