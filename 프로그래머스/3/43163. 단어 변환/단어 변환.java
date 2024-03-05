import java.util.*;

class Solution {
    
    private String begin;
    private String target;
    private String[] words;
    private int[] visited;
    private int result = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        this.begin = begin;
        this.target = target;
        this.words = words;
        this.visited = new int[words.length];
        
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }
        
        dfs(begin, 0);
        return result;
    }
    
    private void dfs(String now, int count) {
        if (now.equals(target)) {
            result = Math.min(count, result);
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            if (!isNext(now, words[i])) {
                continue;
            }
            visited[i] = 1;
            dfs(words[i], count + 1);
            visited[i] = 0;
        }
    }
    
    private boolean isNext(String origin, String next) {
        int count = 0;
        for (int i = 0; i < origin.length(); i++) {
            if (origin.charAt(i) != next.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}