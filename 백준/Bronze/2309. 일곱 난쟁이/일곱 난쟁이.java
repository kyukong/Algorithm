import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static final List<Integer> dwarfs = new ArrayList<>();
    private static final List<Integer> candidates = new ArrayList<>();
    private static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            dwarfs.add(Integer.valueOf(br.readLine()));
        }

        search(0);

        result.sort(Comparator.comparingInt(o -> o));
        for (int dwarf : result) {
            System.out.println(dwarf);
        }
    }

    private static void search(int sum) {
        if (candidates.size() == 7) {
            if (sum == 100) {
                result = new ArrayList<>(candidates);
            }
            return;
        }

        for (int dwarf : dwarfs) {
            if (candidates.contains(dwarf)) {
                continue;
            }
            candidates.add(dwarf);
            search(sum + dwarf);
            candidates.remove(candidates.size() - 1);
        }
    }
}