class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        int[] nums = new int[3];
        int idx = -1;
        for(int i=0; i<dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if(Character.isDigit(c)) {
                idx++;
                if(c == '1' && dartResult.charAt(i + 1) == '0') {
                    nums[idx] = 10;
                    i++;
                } else {
                    nums[idx] = c - '0'; 
                }
            }
        }
        
        String[] str = dartResult.split("[0-9]+");
        
        int[] values = new int[3];
        for(int i=0; i<3; i++) {
            if(str[i+1].charAt(0) == 'S') {
                if(str[i+1].length() == 1) values[i] += nums[i];
                else if(str[i+1].charAt(1) == '*') {
                    values[i] += nums[i] * 2;
                    if(i > 0) values[i-1] *= 2;
                } else if(str[i+1].charAt(1) == '#') values[i] += nums[i] * -1;
            } else if(str[i+1].charAt(0) == 'D') {
                if(str[i+1].length() == 1) values[i] += Math.pow(nums[i], 2);
                else if(str[i+1].charAt(1) == '*') {
                    values[i] += Math.pow(nums[i], 2) * 2;
                    if(i > 0) values[i-1] *= 2;
                } else if(str[i+1].charAt(1) == '#') values[i] += Math.pow(nums[i], 2) * -1;
            } else if(str[i+1].charAt(0) == 'T') {
                if(str[i+1].length() == 1) values[i] += Math.pow(nums[i], 3);
                else if(str[i+1].charAt(1) == '*') {
                    values[i] += Math.pow(nums[i], 3) * 2;
                    if(i > 0) values[i-1] *= 2;
                } else if(str[i+1].charAt(1) == '#') values[i] += Math.pow(nums[i], 3) * -1;
            }
        }
        
        for(int n : values) answer += n;
        return answer;
    }
}