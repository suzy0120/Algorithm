class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        String[][] arr = new String[quiz.length][5];
        for(int i = 0; i < quiz.length; i++) {
            arr[i] = quiz[i].split(" ");
        }
        
        for(int i = 0; i < quiz.length; i++) {
            if(arr[i][1].equals("+")) {
                if(Integer.parseInt(arr[i][4]) == (Integer.parseInt(arr[i][0])+Integer.parseInt(arr[i][2]))) {
                    answer[i] = "O";
                } else {
                    answer[i] = "X";
                }
            } else {
                if(Integer.parseInt(arr[i][4]) == (Integer.parseInt(arr[i][0])-Integer.parseInt(arr[i][2]))) {
                    answer[i] = "O";
                } else {
                    answer[i] = "X";
                }
            }
        }
        return answer;
    }
}