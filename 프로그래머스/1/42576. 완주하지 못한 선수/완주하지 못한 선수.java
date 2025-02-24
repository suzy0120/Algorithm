import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<completion.length; i++) {
            int count = 1;
            if(map.containsKey(completion[i])) map.replace(completion[i], map.get(completion[i])+1);
            else map.put(completion[i], count);
        }
        
        for(int i=0; i<participant.length; i++) {
            if(map.containsKey(participant[i])) {
                if(map.get(participant[i]) == 1) map.remove(participant[i]);
                else map.replace(participant[i], map.get(participant[i])-1);
                continue;
            }
            
            answer = participant[i];
            break;
        }
        
        return answer;
    }
}