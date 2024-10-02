import java.util.*;

class Solution {
    
    private final Map<String, Integer> sorted = new HashMap<>();
    
    public int solution(String[][] clothes) {
        
        for (String[] clothe : clothes) {
            String kind = clothe[1];
            String name = clothe[0];
            
            sorted.put(kind, sorted.getOrDefault(kind, 0) + 1);
        }
        
        int answer = 1;
        for (int value : sorted.values()) {
            answer *= value + 1;
        }
        return answer - 1;
    }
}