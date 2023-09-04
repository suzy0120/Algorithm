import java.util.Arrays;

class Solution {
    public String[] solution(String myString) {
        String[] answer = myString.replace("x", " ").trim().split("\\s+");
        Arrays.sort(answer);
        return answer;
    }
}