class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ", -1);
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i].length() > 0)
                arr[i] = Character.toUpperCase(arr[i].charAt(0)) + arr[i].substring(1).toLowerCase();
        }
        
        for(int i=0; i<arr.length; i++) {
            answer+=arr[i];
            if(i!=arr.length-1) answer+=" ";
        }
        
        return answer;
    }
}