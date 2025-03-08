import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Map<Integer, String> HEAD = new HashMap<>();
        Map<Integer, Integer> NUMBER = new HashMap<>();
        
        for(int i=0; i<files.length; i++) {
            int len = 0;
            String file = files[i];
            
            for(int j=0; j<file.length(); j++) {
                char c = files[i].charAt(j);
                
                if(!HEAD.containsKey(i) && Character.isDigit(c)) {
                    HEAD.put(i, file.toLowerCase().substring(0, j));
                    len = j;
                }
                
                if(Character.isDigit(c) && (j+1 == file.length() || !Character.isDigit(files[i].charAt(j+1)))) {
                    int num = Integer.parseInt(file.substring(len, j+1));
                    NUMBER.put(i, num);
                    break;
                }
            }
        }
        
        List<Integer> fileIndexes = new ArrayList<>(HEAD.keySet());
        
        fileIndexes.sort((i1, i2) -> {
            int headCompare = HEAD.get(i1).compareTo(HEAD.get(i2)); // HEAD 비교
            return (headCompare != 0) ? headCompare : Integer.compare(NUMBER.get(i1), NUMBER.get(i2));
        });
        
        String[] answer = new String[files.length];
        for(int i=0; i<fileIndexes.size(); i++) {
            answer[i] = files[fileIndexes.get(i)];
        }
        
        return answer;
    }
}