class Solution {
    
    private int n;

    public String[] solution(int n, int[] arr1, int[] arr2) {
        this.n = n;

        String[][] map = new String[n][n];
        for (int i = 0; i < n; i++) {
            int[] binaries1 = convertBinaryNumber(arr1[i]);
            int[] binaries2 = convertBinaryNumber(arr2[i]);

            for (int j = 0; j < n; j++) {
                if (binaries1[j] == 1 || binaries2[j] == 1) {
                    map[i][j] = "#";
                } else {
                    map[i][j] = " ";
                }
            }
        }

        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = String.join("", map[i]);
        }
        return answer;
    }

    private int[] convertBinaryNumber(int number) {
        int[] array = new int[n];
        int index = n - 1;
        while (index >= 0) {
            int nowBinary = (int) Math.pow(2, index);
            if (number >= nowBinary) {
                number -= nowBinary;
                array[n - index - 1] = 1;
            }
            index -= 1;
        }
        return array;
    }
}