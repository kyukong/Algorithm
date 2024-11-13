public class Solution {

    public int solution(String dartResult) {
        int[] scores = new int[3];

        int index = 0; // dartResult 의 index
        int count = 0; // 다트 던진 횟수
        char[] result = dartResult.toCharArray();

        while (index < result.length) {
            // 스타상 : 현재와 이전 점수 두 배
            if (result[index] == '*') {
                scores[count - 1] *= 2;
                if (count > 1) {
                    scores[count - 2] *= 2;
                }
                index++;
                continue;
            }

            // 아차상 : 현재 점수 마이너스
            if (result[index] == '#') {
                scores[count - 1] *= -1;
                index++;
                continue;
            }

            // 다트 던지기
            int end = index + 1;
            char dart;
            while (true) {
                dart = result[end];
                if (dart == 'S' || dart == 'D' || dart == 'T') {
                    break;
                }
                end++;
            }

            int score = Integer.parseInt(dartResult.substring(index, end));
            if (dart == 'S') {
                scores[count] = score;
            } else if (dart == 'D') {
                scores[count] = (int) Math.pow(score, 2);
            } else if (dart == 'T') {
                scores[count] = (int) Math.pow(score, 3);
            }

            index = end + 1;
            count++;
        }

        int answer = 0;
        for (int i = 0; i < scores.length; i++) {
            answer += scores[i];
        }
        return answer;
    }
}