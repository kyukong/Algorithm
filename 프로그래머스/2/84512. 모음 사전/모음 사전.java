import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    private static final char[] vowels = new char[] {'A', 'E', 'I', 'O', 'U'};

    private Set<String> words;

    public int solution(String word) {
        this.words = new HashSet<>();

        generate(new StringBuilder(), 0);
        List<String> sortedWords = words.stream().sorted().collect(Collectors.toList());

        return sortedWords.indexOf(word) + 1;
    }

    private void generate(StringBuilder sb, int step) {
        if (step > 0) {
            words.add(sb.toString());
        }
        if (step >= 5) {
            return;
        }

        for (char vowel : vowels) {
            sb.append(vowel);
            generate(sb, step + 1);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}