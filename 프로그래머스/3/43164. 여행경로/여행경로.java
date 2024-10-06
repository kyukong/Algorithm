import java.util.*;

class Solution {
    
    private static final String START = "ICN";
    
    private String[][] tickets;
    private int[] visited;
    private List<List<String>> result = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        this.tickets = sort(tickets);
        this.visited = new int[tickets.length];
        
        List<String> paths = new ArrayList<>();
        paths.add(START);
        dfs(START, paths);
        
        String[] answer = new String[tickets.length + 1];
        for (int i = 0; i < tickets.length + 1; i++) {
            answer[i] = result.get(0).get(i);
        }
        return answer;
    }
    
    // 알파벳 순으로 오름차순 정렬
    private String[][] sort(String[][] array) {
        Arrays.sort(array, (o1, o2) -> {
            int result = o1[0].compareTo(o2[0]);
            if (result == 0) {
                return o1[1].compareTo(o2[1]);
            }
            return result;
        });
        return array;
    }
    
    private void dfs(String area, List<String> paths) {
        if (paths.size() == tickets.length + 1) {
            result.add(new ArrayList<>(paths));
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            if (!tickets[i][0].equals(area)) {
                continue;
            }
            
            visited[i] = 1;
            paths.add(tickets[i][1]);
            
            dfs(tickets[i][1], paths);
            
            visited[i] = 0;
            paths.remove(paths.size() - 1);
        }
    }
}