import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dictionary = new LinkedHashMap<>();
        char c = 'A';
        for(int i=1; i<=26; i++) {
            String s = String.valueOf(c);
            dictionary.put(s, i);
            c++;
        }
        
        List<Integer> list = new ArrayList<>();
        int num = 26;
        loop : for(int i=0; i<msg.length(); i++) {
            boolean visited = false;
            int len = 0;
            for(int j=i+1; j<=msg.length(); j++) {
                String s = msg.substring(i, j);
                if(dictionary.containsKey(s)) {
                    if(visited) list.remove(list.size()-1);
                    list.add(dictionary.get(s));
                    if(i+s.length() >= msg.length()) break loop;
                    visited = true;
                    len = s.length()-1;
                } else {
                    dictionary.put(s, num+=1);
                    i+=len;
                    break;
                }
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}