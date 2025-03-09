import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        int count = 0;
        for(int i=0; i<record.length; i++) {
            if(record[i].charAt(0) != 'C') count++;
        }
        
        Map<String, String> map = new HashMap<>();
        
        for(int i=0; i<record.length; i++) {
            String[] word = record[i].split(" ");
            
            if(word[0].equals("Enter")) {
                map.put(word[1], word[2]);
            } else if(word[0].equals("Change")) {
                if(map.containsKey(word[1])) {
                    map.replace(word[1], word[2]);
                }
            }
        }
        
        String[] answer = new String[count];
        int idx =0;
        for(String s : record) {
            String[] word = s.split(" ");
            if(word[0].equals("Enter") && map.containsKey(word[1])) {
                answer[idx] = map.get(word[1]);
                answer[idx++] += "님이 들어왔습니다.";
            } else if(word[0].equals("Leave")) {
                answer[idx] = map.get(word[1]);
                answer[idx++] += "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}