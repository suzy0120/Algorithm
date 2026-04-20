class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] values = new int[3];
        int idx = -1;
        
        for(int i=0; i<dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            
            if(Character.isDigit(c)) { // 숫자
                idx++;
                if(c == '1' && dartResult.charAt(i + 1) == '0') {
                    values[idx] = 10;
                    i++;
                } else values[idx] = c - '0'; 
            }
            
            else if(c == 'S' || c == 'D' || c == 'T') { // 제곱
                int pow = (c == 'S') ? 1 : (c == 'D') ? 2 : 3;
                values[idx] = (int) Math.pow(values[idx], pow);
            }
            
            else if(c == '*') { // 옵션
                values[idx] *= 2;
                if(idx > 0) values[idx-1] *= 2;
            } else if(c == '#') {
                values[idx] *= -1;
            }
        }
        
        for(int n : values) answer += n;
        return answer;
    }
}