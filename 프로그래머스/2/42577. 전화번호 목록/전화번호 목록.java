import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        
        for(String p : phone_book) {
            set.add(p);
        }
        
        for(String phone : phone_book) {
            for(int i=1; i<phone.length(); i++) {
                String s = phone.substring(0, i);
                
                if(set.contains(s)) return false;
            }
        }
        
        return true;
    }
}