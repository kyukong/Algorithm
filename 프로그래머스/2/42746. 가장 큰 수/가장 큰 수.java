import java.util.*;

class Solution {
    
    public String solution(int[] numbers) {
        
        // array > list
        List<String> nums = new ArrayList<>();
        for (int number : numbers) {
            nums.add(Integer.toString(number));
        }
        
        // numbers 정렬
        nums.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        // 문자열 이어붙이기 (StringBuilder 이용)
        StringBuilder sb = new StringBuilder();
        for (String num : nums) {
            sb.append(num);
        }
        String answer = new String(sb);
        
        // 앞에 0 제거
        if (answer.charAt(0) == '0') {
            answer = "0";
        }
        
        return answer;
    }
}