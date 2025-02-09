import java.util.*;

class Solution {
    public String solution(String bin1, String bin2) {
        int n = 1;
        int num1 = (bin1.charAt(bin1.length()-1)-'0')*1;
        for(int i=bin1.length()-2; i>=0; i--) {
            num1 += Math.pow(2, n) * (bin1.charAt(i)-'0');
            n++;
        }
        
        n = 1;
        int num2 = (bin2.charAt(bin2.length()-1)-'0')*1;
        for(int i=bin2.length()-2; i>=0; i--) {
            num2 += Math.pow(2, n) * (bin2.charAt(i)-'0');
            n++;
        }
        
        int num = num1+num2;
        
        String answer = "";
        if(num==0) answer = "0";
        while(num > 0) {
            answer = (num%2) + answer;
            num=num/2;
        }
        
        return answer;
    }
}