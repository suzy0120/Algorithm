class Solution {
    public String solution(String my_string, int[] indices) {
        char[] c = my_string.toCharArray();
        String answer = "";
        for(int i = 0; i < indices.length; i++) {
            c[indices[i]] = ' ';
        }
        for(int i = 0; i < c.length; i++) {
            if(c[i] != ' ') {
                answer += c[i];
            }
        }
        return answer;
    }
}