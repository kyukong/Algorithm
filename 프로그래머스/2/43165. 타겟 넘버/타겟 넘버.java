class Solution {
    
    private int[] numbers;
    private int target;
    private int result = 0;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
    
        dfs(0, 0);
        
        return result;
    }
    
    private void dfs(int now, int i) {
        if (i >= numbers.length) {
            if (now == target) {
                result++;
            }
            return;
        }
        
        dfs(now + numbers[i], i + 1);
        dfs(now - numbers[i], i + 1);
    }
}