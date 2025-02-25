import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.replaceAll("[{},]", " ");
        String[] arr = s.split(" ", -1);
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            if(arr[i].equals("")) continue;
            
            int num = Integer.parseInt(arr[i]);
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        int[][] kv = new int[map.size()][2];
        int idx = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            kv[idx][0] = entry.getKey();
            kv[idx][1] = entry.getValue();
            idx++;
        }
        
        Arrays.sort(kv, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(b[1], a[1]);
            }
        });
        
        int[] answer = new int[map.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = kv[i][0];
        }
        
        return answer;
    }
}