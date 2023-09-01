class Solution {
    public String[] solution(String[] names) {
        int N = 0;
        if(names.length % 5 == 0) {
            N = names.length / 5;
        } else {
            N = names.length / 5 + 1;
        }
        String[] answer = new String[N];
        int idx = 0;
        for(int i = 0; i < names.length; i++) {
            if(i % 5 == 0) {
                answer[idx++] = names[i];
            }
        }
        return answer;
    }
}