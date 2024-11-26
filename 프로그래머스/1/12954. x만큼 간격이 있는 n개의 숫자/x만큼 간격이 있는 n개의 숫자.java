class Solution {
    
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long number = x;
        for (int i = 0; i < n; number += x, i++) {
            answer[i] = number;
        }
        return answer;
    }
}