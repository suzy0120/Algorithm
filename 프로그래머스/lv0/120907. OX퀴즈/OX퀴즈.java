class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        String[][] arr = new String[quiz.length][5];
        for(int i = 0; i < quiz.length; i++) {
            arr[i] = quiz[i].split(" ");
        }
        
        for(int r = 0; r < quiz.length; r++) {
            if(arr[r][1].equals("+")) {
                if(Integer.parseInt(arr[r][4]) == (Integer.parseInt(arr[r][0]) + Integer.parseInt(arr[r][2]))) {
                    answer[r] = "O";
                } else {
                    answer[r] = "X";
                }
            } else {
                if(Integer.parseInt(arr[r][4]) == (Integer.parseInt(arr[r][0]) - Integer.parseInt(arr[r][2]))) {
                    answer[r] = "O";
                } else {
                    answer[r] = "X";
                }
            }
        }
        return answer;
    }
}