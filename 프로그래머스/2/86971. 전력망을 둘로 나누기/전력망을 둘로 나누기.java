import java.util.*;

public class Solution {

    private Map<Integer, List<Integer>> tops;
    private int n;
    private int result;

    public int solution(int n, int[][] wires) {
        this.n = n;
        this.tops = new HashMap<>();
        this.result = Integer.MAX_VALUE;

        // 입력값 자료구조 변경
        for (int i = 0; i < wires.length; i++) {
            int first = wires[i][0];
            int second = wires[i][1];

            List<Integer> list1 = tops.getOrDefault(first, new ArrayList<>());
            list1.add(second);
            tops.put(first, list1);

            List<Integer> list2 = tops.getOrDefault(second, new ArrayList<>());
            list2.add(first);
            tops.put(second, list2);
        }

        // 전력망 분리
        for (int i = 1; i <= n; i++) {
            List<Integer> list = new ArrayList<>(tops.get(i));
            for (int j : list) {
                List<Integer> list1 = tops.get(i);
                List<Integer> list2 = tops.get(j);

                list1.remove(Integer.valueOf(j));
                list2.remove(Integer.valueOf(i));

                int count1 = bfs(i);
                int count2 = bfs(j);
                result = Math.min(result, Math.abs(count1 - count2));

                list1.add(j);
                list2.add(i);
            }
        }
        return result;
    }

    // 노드 개수 세기
    private int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int[] visited = new int[n + 1];

        while (!queue.isEmpty()) {
            int now = queue.poll();
            visited[now] = 1;

            List<Integer> connected = tops.get(now);
            for (int i : connected) {
                if (visited[i] == 1) {
                    continue;
                }
                queue.offer(i);
            }
        }

        int count = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 1) {
                count++;
            }
        }

        return count;
    }
}