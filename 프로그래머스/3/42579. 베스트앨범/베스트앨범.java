import java.util.*;

class Solution {
    
    private final Map<String, Integer> sum = new HashMap<>();
    private final Map<String, List<List<Integer>>> song = new HashMap<>();
    
    public int[] solution(String[] genres, int[] plays) {
        
        for (int i = 0; i < plays.length; i++) {
            // 장르 별로 저장
            List<Integer> play = new ArrayList<>();
            play.add(plays[i]); // 재생횟수
            play.add(i); // 인덱스
            
            List<List<Integer>> temp = song.getOrDefault(genres[i], new ArrayList<>());
            temp.add(play);
            
            song.put(genres[i], temp); // TODO 리스트 정렬 정의 필요 (1요소 기준 내림차순)
            
            // 재생 횟수 합계 저장
            sum.put(genres[i], sum.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // 장르 별로 저장한 리스트를 고유번호 내림차순으로 정렬
        for (List<List<Integer>> temp : song.values()) {
            temp.sort((o1, o2) -> {
                if (o1.get(0) == o2.get(0)) {
                    return o2.get(1) - o1.get(1);
                }
                return o2.get(0) - o1.get(0);
            });
        }
        
        // 재생 횟수 기준 내림차순 정렬
        List<Map.Entry<String, Integer>> sortedValue = new LinkedList<>(sum.entrySet());
        sortedValue.sort((o1, o2) -> o2.getValue() - o1.getValue());
        
        // 장르 중 2개 곡 추출
        List<Integer> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortedValue) {
            String genre = entry.getKey();
            
            int count = 0;
            for (List<Integer> number : song.get(genre)) {
                if (count++ < 2) {
                    answer.add(number.get(1));
                    continue;
                }
                break;
            }
        }
        
        // list > array
        int[] result = new int[answer.size()];
        int index = 0;
        for (int number : answer) {
            result[index++] = number;
        }
        
        return result;
    }
}