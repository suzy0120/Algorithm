import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0; i<s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;
            
            for(int j=0; j<s.length(); j++) {
                char ch = s.charAt((i+j) % s.length());
                
                if(ch=='(' || ch=='[' || ch=='{') stack.push(ch);
                else {
                    if(stack.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    
                    if((ch == ')' && stack.pop() != '(') ||
                       (ch == ']' && stack.pop() != '[') ||
                       (ch == '}' && stack.pop() != '{')) {
                        isValid = false;
                        break;
                    }
                }
            }
            
            if(isValid && stack.isEmpty()) answer++;
        }
        
        return answer;
    }
}