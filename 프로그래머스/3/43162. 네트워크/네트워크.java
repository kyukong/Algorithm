import java.util.*;

class Solution {
    
    private int[] area;
    private Map<Integer, List<Integer>> connections = new HashMap<>();
    
    public int solution(int n, int[][] computers) {
        
        area = new int[n];
        List<Integer> connection;
        for (int i = 0; i < n; i++) {
            
            area[i] = i;
            
            connection = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (i == j || computers[i][j] == 0) {
                    continue;
                }
                connection.add(j);
            }
            connections.put(i, connection);
        }
        
        // System.out.println(Arrays.toString(area));
        // System.out.println(connections);
        
        int com, parent1, parent2;
        for (Map.Entry<Integer, List<Integer>> now : connections.entrySet()) {
            com = now.getKey();
            // System.out.println("now : " + com);
            
            for (int other : now.getValue()) {
                parent1 = find(com);
                parent2 = find(other);
                
                if (parent1 == parent2) {
                    continue;
                }
                
                for (int i = 0; i < n; i++) {
                    if (area[i] == parent2) {
                        area[i] = parent1;
                    }
                }
                
                // area[other] = parent1;
            }
            // System.out.println(Arrays.toString(area));
        }
        
        // System.out.println(Arrays.toString(area));
        
        return Arrays.stream(area).distinct().toArray().length;
    }
    
    private int find(int value) {
        if (value == area[value]) {
            return value;
        }
        return area[value] = find(area[value]);
    }
}