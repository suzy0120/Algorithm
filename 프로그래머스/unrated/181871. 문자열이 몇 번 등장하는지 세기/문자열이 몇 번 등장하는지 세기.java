class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        String same = "";
        for(int i = 0; i <= myString.length()-pat.length(); i++) {
            same = myString.substring(i, i+pat.length());
            if(pat.equals(same)) {
                answer++;
            }
        }
        return answer;
    }
}