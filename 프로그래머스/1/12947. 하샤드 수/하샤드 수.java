class Solution {
    
    public boolean solution(int x) {
        String strX = String.valueOf(x);
        int sum = 0;
        for (int i = 0; i < strX.length(); i++) {
            sum += Integer.parseInt(String.valueOf(strX.charAt(i)));
        }
        return x % sum == 0;
    }
}