import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        for(int i=0; i<records.length; i++) {
            String[] details = records[i].split(" ");
            
            if(!map1.containsKey(details[1])) map1.put(details[1], details[0]);
            else {
                String[] minuteIn = map1.get(details[1]).split(":");
                String[] minuteOut = details[0].split(":");
                
                int hour = Integer.parseInt(minuteOut[0]) - Integer.parseInt(minuteIn[0]);
                int minute = Integer.parseInt(minuteOut[1]) - Integer.parseInt(minuteIn[1]);
                if(Integer.parseInt(minuteOut[1]) < Integer.parseInt(minuteIn[1])) {
                    hour-=1;
                    minute = (Integer.parseInt(minuteOut[1])+60) - Integer.parseInt(minuteIn[1]);
                }
                int total = hour * 60 + minute;
                
                map1.remove(details[1]);
                
                if(map2.containsKey(details[1])) {
                    map2.replace(details[1], map2.get(details[1])+total);
                } else map2.put(details[1], total);
            }
        }
        
        if(!map1.isEmpty()) {
            for(String key : map1.keySet()) {
                String[] minuteIn = map1.get(key).split(":");
                
                int hour = 23 - Integer.parseInt(minuteIn[0]);
                int minute = 59 - Integer.parseInt(minuteIn[1]);
                int total = hour * 60 + minute;
                
                if(map2.containsKey(key)) {
                    map2.replace(key, map2.get(key)+total);
                } else map2.put(key, total);
            }
        }
        
        List<String> keys = new ArrayList<>(map2.keySet());
        Collections.sort(keys);System.out.println(keys);
        
        int[] answer = new int[map2.size()];
        int idx = 0;
        for(String key : keys) {
            if(map2.get(key) > fees[0]) {
                answer[idx++] = fees[1] + (int) Math.ceil((double) (map2.get(key)-fees[0])/fees[2]) * fees[3];
            } else {
                answer[idx++] = fees[1];
            }
        }
        
        return answer;
    }
}