import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
            if(c == '(') stack.add(c);
            else {
                if(stack.isEmpty()) {
                    answer = false;
                    break;
                }
                
                stack.pop();
            }
        }
        
        if(!stack.isEmpty()) answer = false;
        
        return answer;
    }
}