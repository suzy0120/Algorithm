class Solution {
    public int solution(int[] array) {
        int answer = 0;
        String[] num = new String[array.length];
        
        for(int i = 0; i < array.length; i++) {
            num[i] = array[i] + "";
            for(int j = 0; j < num[i].length(); j++) {
                if(num[i].charAt(j) == '7')
                    answer++;
            }
        }
        
        return answer;
    }
}