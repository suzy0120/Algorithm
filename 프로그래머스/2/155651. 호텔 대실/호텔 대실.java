import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int same = 0;
        
        int[][] time = new int[book_time.length][2];
        for(int i=0; i<book_time.length; i++) {
            time[i][0] = Integer.parseInt(book_time[i][0].substring(0, 2))*60 +
                         Integer.parseInt(book_time[i][0].substring(3));
            time[i][1] = Integer.parseInt(book_time[i][1].substring(0, 2))*60 +
                         Integer.parseInt(book_time[i][1].substring(3))+10;
        }
        
        Arrays.sort(time, (a, b) -> Integer.compare(a[0], b[0]));
        
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int[] t : time) {
            int start = t[0];
            int end = t[1];
            
            Integer earliest = map.floorKey(start);
            if (earliest != null) {
                int count = map.get(earliest);
                if (count == 1) {
                    map.remove(earliest);
                } else {
                    map.put(earliest, count - 1);
                }
            } else {
                answer++;
            }
            
            map.put(end, map.getOrDefault(end, 0) + 1);
        }
        
        return answer;
    }
}