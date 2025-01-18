class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] sArr = s.split(" ", -1); // 공백 유지하며 split
        
        for(int i=0; i<sArr.length; i++) {
            for(int j=0; j<sArr[i].length(); j++) {
                if(j%2==0) answer.append(Character.toUpperCase(sArr[i].charAt(j)));
                else answer.append(Character.toLowerCase(sArr[i].charAt(j)));
            }
            if(i < sArr.length-1) answer.append(" ");
        }
        
        return answer.toString();
    }
}