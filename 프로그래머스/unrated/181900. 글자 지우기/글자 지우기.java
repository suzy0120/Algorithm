class Solution {
    public String solution(String my_string, int[] indices) {
        // ArrayList<Character> list = new ArrayList<>();
        char[] c = my_string.toCharArray();
        String answer = "";
        for(int i = 0; i < indices.length; i++) {
            c[indices[i]] = 'A';
        }
        for(int i = 0; i < c.length; i++) {
            if(c[i] != 'A') {
                answer += c[i];
            }
        }
        return answer;
    }
}