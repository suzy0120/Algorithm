import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int current = getDate(today);
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<privacies.length; i++) {
            String[] parts = privacies[i].split(" ");
            int expiration = getDate(parts[0]);
            
            for(int k=0; k<terms.length; k++) {
                String[] month = terms[k].split(" ");
                int plus = Integer.parseInt(month[1]);
                if(parts[1].equals(month[0])) expiration+=(plus*28);
            }
            
            if(current >= expiration) list.add(i+1);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public int getDate(String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        return ((year-2000)*12*28) + (month*28) + day;
    }
}