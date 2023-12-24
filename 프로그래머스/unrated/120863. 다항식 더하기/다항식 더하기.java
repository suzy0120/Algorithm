class Solution {
    public String solution(String polynomial) {
        String answer = "";
        String[] arr = polynomial.split(" ");
        int x = 0;
        int sum = 0;
        int num = 0;
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].contains("x")) { // x 계산해주기
                if(arr[i].equals("x")) sum += 1;
                else {
                    x = Integer.valueOf(arr[i].substring(0, arr[i].length()-1));
                    sum += x;
                }
            } else if(!arr[i].equals("+")) { // 양의 정수 계산해주기
                num += Integer.parseInt(arr[i]);
            }
        }
        
        if(sum == 0) { // 양의 정수만 있다면
            answer = num + "";
        } else if(num == 0) { // x 만 있다면
            if(sum == 1) answer = "x";
            else answer = sum + "x";
        } else { // 둘 다 존재한다면
            if(sum == 1) answer = "x + " + num;
            else answer = sum + "x + " + num;
        }
        
        return answer;
    }
}