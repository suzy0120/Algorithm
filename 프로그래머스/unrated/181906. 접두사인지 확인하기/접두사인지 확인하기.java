class Solution {
    public int solution(String my_string, String is_prefix) {
        int answer = 0;
        int k = 0;
        String[] s = new String[my_string.length()];
        for(int i = 0; i < my_string.length(); i++) {
            s[i] = my_string.substring(0, k);
            k++;
        }
        for(int i = 0; i < s.length; i++) {
            if(is_prefix.equals(s[i])) {
                answer = 1;
            }
        }
        return answer;
    }
}