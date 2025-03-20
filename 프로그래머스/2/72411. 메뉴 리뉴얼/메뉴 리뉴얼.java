import java.util.*;

class Solution {
    public static Map<String, Integer> map = new HashMap<>();
    public static char[] c;
    public static boolean visit[];
    public static int len;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();
        
        for(int courseSize : course) {
            len = courseSize;
            map.clear();
            
            for(String order : orders) {
                if(order.length() < len) continue;
                
                c = order.toCharArray();
                Arrays.sort(c);
                
                visit = new boolean[c.length];
                
                DFS(0, 0);
            }
            
            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
            
            if(!list.isEmpty() && list.get(0).getValue() >= 2) {
                int max = list.get(0).getValue();
                
                for(Map.Entry<String, Integer> entry : list) {
                    if(entry.getValue() != max) break;
                    
                    result.add(entry.getKey());
                }
            }
        }
        
        Collections.sort(result);
        
        return result.toArray(new String[result.size()]);
    }
    
    private void DFS(int start, int count) {
        if(count == len) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<c.length; i++) {
                if(visit[i]) sb.append(c[i]);
            }
            
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+1);
            return;
        }
        
        for(int i=start; i<c.length; i++) {
            visit[i] = true;
            DFS(i+1, count+1);
            visit[i] = false;
        }
    }
}