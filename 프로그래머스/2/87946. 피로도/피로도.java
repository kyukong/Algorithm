class Solution {

    private int[][] dungeons;
    private int[] visited;
    private int result = 0;
    
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        this.visited = new int[dungeons.length];

        dfs(k, 0);

        return result;
    }

    private void dfs(int health, int count) {
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            if (health >= dungeons[i][0]) {
                visited[i] = 1;
                dfs(health - dungeons[i][1], count + 1);
                visited[i] = 0;
            }
        }
        result = Math.max(result, count);
    }
}