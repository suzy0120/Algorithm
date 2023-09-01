class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        char[] arr = myString.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 'A') {
                arr[i] = 'B';
            } else {
                arr[i] = 'A';
            }
            myString = "";
            myString = String.valueOf(arr);
        }
            System.out.println(myString);
        if(myString.contains(pat)) {
            answer = 1;
        }
        return answer;
    }
}