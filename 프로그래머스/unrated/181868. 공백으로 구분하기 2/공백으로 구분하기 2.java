class Solution {
    public String[] solution(String my_string) {
        String[] s = my_string.split(" ");
        int idx = 0;
        int count = 0;
        for(int i = 0; i < s.length; i++) {
            if(!s[i].equals("")) {
                count++;
            }
        }
        String[] answer = new String[count];
        for(int i = 0; i < s.length; i++) {
            if(!s[i].equals("")) {
                answer[idx++] = s[i];
            }
        }
        return answer;
    }
}