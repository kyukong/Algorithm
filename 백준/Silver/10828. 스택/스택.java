import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        String command;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();

            if (command.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (command.equals("pop")) {
                if (stack.empty()) {
                    sb.append("-1").append("\n");
                    continue;
                }
                sb.append(stack.pop()).append("\n");
            } else if (command.equals("size")) {
                sb.append(stack.size()).append("\n");
            } else if (command.equals("empty")) {
                if (stack.empty()) {
                    sb.append("1").append("\n");
                    continue;
                }
                sb.append("0").append("\n");
            } else if (command.equals("top")) {
                if (stack.empty()) {
                    sb.append("-1").append("\n");
                    continue;
                }
                sb.append(stack.peek()).append("\n");
            }
        }
        System.out.println(sb);
    }
}