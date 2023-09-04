class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String ab = String.valueOf(a) + String.valueOf(b);
        int twoab = 2 * a * b;
        if(Integer.parseInt(ab) >= twoab) {
            answer = Integer.parseInt(ab);
        } else {
            answer = twoab;
        }
        return answer;
    }
}