public class Solution {

    private int result;
    private int[] nums;

    public int solution(int[] nums) {
        this.nums = nums;
        this.result = 0;
        
        combination(0, 0, 0, new int[nums.length]);
        
        return result;
    }

    private void combination(int start, int count, int sum, int[] visited) {
        if (count == 3) {
            if (isPrime(sum)) {
                result++;
            }
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            count++;
            sum += nums[i];

            combination(i + 1, count, sum, visited);

            visited[i] = 0;
            count--;
            sum -= nums[i];
        }
    }

    private boolean isPrime(int num) {
        int count = 0;
        for (int i = num; i > 0; i--) {
            if (num % i == 0) {
                count++;
                if (count > 2)  {
                    return false;
                }
            }
        }
        return count == 2;
    }
}