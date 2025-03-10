import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        
        for(String r : record) {
            String[] word = r.split(" ");
            
            if(!word[0].equals("Leave")) map.put(word[1], word[2]);
        }
        
        for(String r : record) {
            String[] word = r.split(" ");
            
            if(word[0].equals("Enter")) {
                list.add(map.get(word[1]) + "님이 들어왔습니다.");
            } else if(word[0].equals("Leave")) {
                list.add(map.get(word[1]) + "님이 나갔습니다.");
            }
        }
        
        String[] answer = new String[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
        // return list.toArray(new String[0]);
    }
}