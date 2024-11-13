import java.util.*;

public class Solution {

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> counts = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            if (i < participant.length - 1) {
                counts.put(completion[i], counts.getOrDefault(completion[i], 0) - 1);
            }
            counts.put(participant[i], counts.getOrDefault(participant[i], 0) + 1);
        }

        String answer = "";
        for (String key : counts.keySet()) {
            if (counts.get(key) == 1) {
                answer = key;
                break;
            }
        }
        return answer;
    }
}