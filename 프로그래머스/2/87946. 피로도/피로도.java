public class Solution {

    private int[][] dungeons;
    private int result = 0;

    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;

        go(k, 0, new int[dungeons.length]);

        return result;
    }

    public void go(int hp, int step, int[] visited) {
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i] == 1 || hp < dungeons[i][0]) {
                continue;
            }
            visited[i] = 1;
            go(hp - dungeons[i][1], step + 1, visited);
            visited[i] = 0;
        }
        result = Math.max(result, step);
    }
}