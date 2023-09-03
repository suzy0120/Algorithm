class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int mult = 1;
        for(int i = 0; i < num_list.length; i++) {
            if(num_list.length >= 11) {
                answer += num_list[i];
            } else {
                mult *= num_list[i];
                answer = mult;
            }
        }
        return answer;
    }
}