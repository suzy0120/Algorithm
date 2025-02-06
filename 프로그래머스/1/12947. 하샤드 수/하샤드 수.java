class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        char[] array = String.valueOf(x).toCharArray();
        int sum = 0;
        
        for(char c : array) {
            sum+=c-'0';
        }
        
        if(x%sum!=0) answer = false;
        return answer;
    }
}