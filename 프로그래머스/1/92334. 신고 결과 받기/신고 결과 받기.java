import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for(int i=0; i<id_list.length; i++) {
            map.put(id_list[i], i);
        }
        
        int[][] table = new int[id_list.length][id_list.length];
        int[] count = new int[id_list.length];
        for(String s : report) {
            String[] name = s.split(" ");
            int r = map.get(name[0]);
            int c = map.get(name[1]);
            if(table[r][c] == 0) {
                table[r][c]++;
                count[c]++;
            }
        }
        
        List<String> list = new ArrayList<>();
        for(int c=0; c<count.length; c++) {
            if(count[c] >= k) list.add(id_list[c]);
        }
        
        int[] answer = new int[id_list.length];
        for(int r=0; r<table.length; r++) {
            for(int c=0; c<table.length; c++) {
                if(table[r][c] == 1) {
                    for(int i=0; i<list.size(); i++) {
                        if(id_list[c].equals(list.get(i))) {
                            answer[r]++;
                            break;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}