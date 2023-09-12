class Solution {
    public int solution(String my_string) {
        String[] arr = my_string.split(" ");
        int answer = Integer.parseInt(arr[0]);
        for(int i = 0; i < arr.length-1; i+=2) {
            if(arr[i+1].equals("+")) {
                answer += Integer.parseInt(arr[i+2]);
            } else {
                answer -= Integer.parseInt(arr[i+2]);
            }
        }
        return answer;
    }
}