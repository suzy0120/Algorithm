import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dictionary = new HashMap<>();
        List<Integer> output = new ArrayList<>();
        
        for(int i=0; i<26; i++) {
            dictionary.put(String.valueOf((char) ('A'+i)), i+1);
        }
        
        int num = 27;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<msg.length();) {
            sb.setLength(0); // StringBuilder 초기화
            sb.append(msg.charAt(i));
            int j=i+1;
            
            while(j < msg.length() && dictionary.containsKey(sb.toString()+msg.charAt(j))) {
                sb.append(msg.charAt(j));
                j++;
            }
            
            output.add(dictionary.get(sb.toString()));
            
            if(j < msg.length()) dictionary.put(sb.toString()+msg.charAt(j), num++);
            
            i += sb.length();
        }
        
        int[] answer = new int[output.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = output.get(i);
        }
        
        return answer;
    }
}