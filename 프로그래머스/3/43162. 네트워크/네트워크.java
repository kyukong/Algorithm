import java.util.*;

class Solution {
    
    private int n;
    private int[][] computers;
    private int result = 0;
    private int[] visited;
    
    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        this.visited = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (visited[i] == 1) {
                continue;
            }
            result++;
            bfs(i);
        }
        
        return result;
    }
    
    private void bfs(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(start);
        
        while (!q.isEmpty()) {
            int computer = q.poll();
            int[] network = computers[computer];
            visited[computer] = 1;
            
            for (int i = 0; i < network.length; i++) {
                if (network[i] == 0 || visited[i] == 1) {
                    continue;
                }
                q.offer(i);
            }
        }
    }
}