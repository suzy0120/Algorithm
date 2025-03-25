import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Queue<Character> q = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        Map<String, Integer> map = new HashMap<>();
        
        int seq = 0;
        while(seq < s.length()) {
            for(char c : s.toCharArray()) {
                q.add(c);
            }
            
            s = s.substring(1) + s.charAt(0);
            seq++;
            
            while(!q.isEmpty()) {
                if(q.peek()=='(') {
                    stack.add(q.poll());
                    map.put("()", map.getOrDefault("()", 0)+1);
                } else if(q.peek()=='[') {
                    stack.add(q.poll());
                    map.put("[]", map.getOrDefault("[]", 0)+1);
                } else if(q.peek()=='{') {
                    stack.add(q.poll());
                    map.put("{}", map.getOrDefault("{}", 0)+1);
                } else if(q.peek()==')') {
                    if(stack.isEmpty() || stack.peek() != '(') break;
                    
                    q.poll();
                    stack.pop();
                    
                    map.put("()", map.getOrDefault("()", 0)-1);
                    if(map.get("()") < 0) break;
                } else if(q.peek()==']') {
                    if(stack.isEmpty() || stack.peek() != '[') break;
                    
                    q.poll();
                    stack.pop();
                    
                    map.put("[]", map.getOrDefault("[]", 0)-1);
                    if(map.get("[]") < 0) break;
                } else {
                    if(stack.isEmpty() || stack.peek() != '{') break;
                    
                    q.poll();
                    stack.pop();
                    
                    map.put("{}", map.getOrDefault("{}", 0)-1);
                    if(map.get("{}") < 0) break;
                }
            }
            
            if(q.isEmpty() && stack.isEmpty()) answer++;
            
            q.clear();
            stack.clear();
            map.clear();
        }
        
        return answer;
    }
}