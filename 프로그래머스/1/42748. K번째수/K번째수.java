import java.util.*;

class Solution {
    
    public int[] solution(int[] array, int[][] commands) {
        int testcase = commands.length;
        
        int[] answer = new int[testcase];
        
        for (int t = 0; t < testcase; t++) {
            int[] command = commands[t];
            
            answer[t] = extract(array.clone(),
                            command[0] - 1, command[1] - 1, command[2] - 1);
        }
        return answer;
    }
    
    private int extract(int[] array, int i, int j, int k) {
        int size = j - i + 1;
        int[] splitArray = new int[size];
        
        // 배열 자르기
        int index = 0;
        for (int n = i; n <= j; n++) {
            splitArray[index++] = array[n];
        }
        
        // array > list
        List<Integer> listArray = new ArrayList<>();
        for (int ele : splitArray) {
            listArray.add(ele);
        }
        
        // 오름차순 정렬
        listArray.sort((o1, o2) -> o1 - o2);
        
        // list > array
        int[] sortedArray = new int[size];
        for (int n = 0; n < size; n++) {
            sortedArray[n] = listArray.get(n);
        }
        
        // 적절한 요소 추출
        return sortedArray[k];
    }
}