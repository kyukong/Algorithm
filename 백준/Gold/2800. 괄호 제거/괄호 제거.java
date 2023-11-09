import java.util.*;
import java.io.*;

public class Main {

    private static Set<String> results = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int size = str.length();

        String[] strings = new String[size];
        for (int i = 0; i < size; i++) {
            strings[i] = String.valueOf(str.charAt(i));
        }
        String origin = String.join("", strings);

        dfs(strings, 0);

        for (String result : results) {
            if (result.equals(origin)) {
                continue;
            }
            System.out.println(result);
        }
    }

    private static void dfs(String[] strings, int index) {
        if (index == strings.length - 1) {
            results.add(String.join("", strings));
            return;
        }

        if (!strings[index].equals("(")) {
            dfs(strings, index + 1);
            return;
        }

        // 넘어가기
        dfs(strings, index + 1);

        // 제거하기
        remove(strings, index);
    }

    private static void remove(String[] strings, int index) {
        // 쌍에 해당하는 ) 괄호 제거
        strings[index] = "";

        int size = strings.length;
        int count = 0;
        int removedIndex = 0;
        for (int i = index; i < size; i++) {
            if (strings[i].equals("(")) {
                count++;
                continue;
            }
            if (strings[i].equals(")")) {
                if (count > 0) {
                    count--;
                    continue;
                }
                strings[i] = "";
                removedIndex = i;
                break;
            }
        }

        dfs(strings, index + 1);

        // 제거했던 괄호 원상복귀
        strings[index] = "(";
        strings[removedIndex] = ")";
    }
}