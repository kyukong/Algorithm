import java.util.*;

class Solution {
    
    private int[] visited;
    private int n;
    private int[][] computers;
    
    public int solution(int n, int[][] computers) {
        this.visited = new int[n];
        this.n = n;
        this.computers = computers;
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 1) {
                continue;
            }
            dfs(i);
            answer++;
        }
        return answer;
    }
    
    private void dfs(int computer) {
        visited[computer] = 1;
        
        int[] connections = computers[computer];
        
        for (int i = 0; i < connections.length; i++) {
            if (connections[i] == 0) {
                continue;
            }
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            dfs(i);
        }
    }
}