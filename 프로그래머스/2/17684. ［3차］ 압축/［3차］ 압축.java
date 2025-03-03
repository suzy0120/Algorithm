import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dictionary = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<26; i++) {
            dictionary.put(String.valueOf((char) ('A'+i)), i+1);
        }
        
        int num = 27;
        StringBuilder sb = new StringBuilder();
        
        loop : for(int i=0; i<msg.length();) {
            sb.setLength(0);
            sb.append(msg.charAt(i));
            boolean visited = false;
            int len = 0;
            
            for(int j=i+1; j<=msg.length(); j++) {
                if(dictionary.containsKey(sb.toString())) {
                    if(visited) list.remove(list.size()-1);
                    list.add(dictionary.get(sb.toString()));
                    
                    if(i+sb.length() >= msg.length()) break loop;
                    
                    visited = true;
                    len = sb.length();
                } else {
                    dictionary.put(sb.toString(), num++);
                    i+=len;
                    break;
                }
                
                if(j < msg.length()) sb.append(msg.charAt(j));
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}