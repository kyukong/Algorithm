public class Solution {

    public int[] solution(int brown, int yellow) {

        int middle = (int) Math.ceil(Math.sqrt(brown + yellow));

        int y;
        for (int x = middle; x > 0; x--) {
            if ((brown + yellow) % x != 0) {
                continue;
            }

            y = (brown + yellow) / x;

            if ((x - 2) * (y - 2) == yellow) {
                return new int[] {Math.max(x, y), Math.min(x, y)};
            }
        }

        return new int[] {0, 0};
    }
}