import java.util.*;

class Solution {
    
    private int answer = Integer.MAX_VALUE;
    private int[] visited;
    private String begin;
    private String target;
    private String[] words;
    
    public int solution(String begin, String target, String[] words) {
        this.visited = new int[words.length];
        this.begin = begin;
        this.target = target;
        this.words = words;
        
        for (int i = 0; i < words.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            if (isNext(begin, words[i])) {
                dfs(i, 1);
            }
        }
        
        if (answer == Integer.MAX_VALUE) {
            return 0;
        }
        return answer;
    }
    
    private void dfs(int index, int step) {
        if (words[index].equals(target)) {
            answer = Math.min(answer, step);
            return;
        }
        
        visited[index] = 1;
        
        for (int i = 0; i < words.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            if (isNext(words[index], words[i])) {
                dfs(i, step + 1);
            }
        }
    }
    
    private boolean isNext(String start, String end) {
        int diff = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == end.charAt(i)) {
                continue;
            }
            diff++;
        }
        return diff == 1;
    }
}