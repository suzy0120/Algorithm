class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        String[] arr1 = my_string.split("");
        String[] arr2 = overwrite_string.split("");
        int idx = 0;
        for(int i = s; i < arr2.length+s; i++) {
            arr1[i] = arr2[idx++];
        }
        for(int i = 0; i < arr1.length; i++) {
            answer += arr1[i];
        }
        return answer;
    }
}