import java.util.*;

class Solution {
    
    private String[][] tickets;
    private int[] visited;
    private List<List<String>> results = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        // tickets 사전순 정렬
        sort(tickets);
        this.tickets = tickets;
        this.visited = new int[tickets.length];
        
        // 여행경로 찾기
        List<String> result = new ArrayList<>();
        result.add("ICN");
        dfs("ICN", result);
        
        return results.get(0).toArray(new String[tickets.length + 1]);
    }
    
    private void sort(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> {
            int result = a[0].compareTo(b[0]);
            if (result == 0) {
                return a[1].compareTo(b[1]);
            }
            return result;
        });
    }
    
    private void dfs(String now, List<String> result) {
        
        if (result.size() == tickets.length + 1) {
            results.add(new ArrayList<>(result));
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (visited[i] == 1 || !tickets[i][0].equals(now)) {
                continue;
            }
            
            visited[i] = 1;
            result.add(tickets[i][1]);
            
            dfs(tickets[i][1], result);
            
            result.remove(result.size() - 1);
            visited[i] = 0;
        }
    }
}