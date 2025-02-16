import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] sToday = today.split("\\.");
        int day = (Integer.parseInt(sToday[0])-2000)*12*28 +
                  Integer.parseInt(sToday[1])*28 +
                  Integer.parseInt(sToday[2]);
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<privacies.length; i++) {
            String[] parts = privacies[i].split(" ");
            String[] tokens = parts[0].split("\\.");
            int date = (Integer.parseInt(tokens[0])-2000)*12*28 +
                       Integer.parseInt(tokens[1])*28 +
                       Integer.parseInt(tokens[2]);
            
            for(int k=0; k<terms.length; k++) {
                String[] month = terms[k].split(" ");
                int plus = Integer.parseInt(month[1]);
                if(parts[1].equals(month[0])) date+=(plus*28);
            }
            if(day >= date) list.add(i+1);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}