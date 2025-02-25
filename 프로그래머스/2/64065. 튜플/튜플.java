import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] arr = s.split("[{},]+");
        
        Map<Integer, Integer> map = new HashMap<>();
        for(String str : arr) {
            if(!str.isEmpty()) {
                int num = Integer.parseInt(str);
                map.put(num, map.getOrDefault(num, 0)+1);
            }
        }
        
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((a, b) -> b.getValue() - a.getValue());
        
        int[] answer = new int[entryList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = entryList.get(i).getKey();
        }
        
        return answer;
    }
}