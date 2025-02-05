class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[][] score = new int[4][2];
        
        for(int i=0; i<survey.length; i++) {
            if(choices[i] == 4) continue;
            
            if(survey[i].contains("R")) {
                if(survey[i].charAt(0) == 'R') {
                    if(choices[i]==1) score[0][0] += 3;
                    else if(choices[i]==2) score[0][0] += 2;
                    else if(choices[i]==3) score[0][0] += 1;
                    else if(choices[i]==5) score[0][1] += 1;
                    else if(choices[i]==6) score[0][1] += 2;
                    else if(choices[i]==7) score[0][1] += 3;
                } else {
                    if(choices[i]==1) score[0][1] += 3;
                    else if(choices[i]==2) score[0][1] += 2;
                    else if(choices[i]==3) score[0][1] += 1;
                    else if(choices[i]==5) score[0][0] += 1;
                    else if(choices[i]==6) score[0][0] += 2;
                    else if(choices[i]==7) score[0][0] += 3;
                }
            } else if(survey[i].contains("C")) {
                if(survey[i].charAt(0) == 'C') {
                    if(choices[i]==1) score[1][0] += 3;
                    else if(choices[i]==2) score[1][0] += 2;
                    else if(choices[i]==3) score[1][0] += 1;
                    else if(choices[i]==5) score[1][1] += 1;
                    else if(choices[i]==6) score[1][1] += 2;
                    else if(choices[i]==7) score[1][1] += 3;
                } else {
                    if(choices[i]==1) score[1][1] += 3;
                    else if(choices[i]==2) score[1][1] += 2;
                    else if(choices[i]==3) score[1][1] += 1;
                    else if(choices[i]==5) score[1][0] += 1;
                    else if(choices[i]==6) score[1][0] += 2;
                    else if(choices[i]==7) score[1][0] += 3;
                }
            } else if(survey[i].contains("J")) {
                if(survey[i].charAt(0) == 'J') {
                    if(choices[i]==1) score[2][0] += 3;
                    else if(choices[i]==2) score[2][0] += 2;
                    else if(choices[i]==3) score[2][0] += 1;
                    else if(choices[i]==5) score[2][1] += 1;
                    else if(choices[i]==6) score[2][1] += 2;
                    else if(choices[i]==7) score[2][1] += 3;
                } else {
                    if(choices[i]==1) score[2][1] += 3;
                    else if(choices[i]==2) score[2][1] += 2;
                    else if(choices[i]==3) score[2][1] += 1;
                    else if(choices[i]==5) score[2][0] += 1;
                    else if(choices[i]==6) score[2][0] += 2;
                    else if(choices[i]==7) score[2][0] += 3;
                }
            } else if(survey[i].contains("A")) {
                if(survey[i].charAt(0) == 'A') {
                    if(choices[i]==1) score[3][0] += 3;
                    else if(choices[i]==2) score[3][0] += 2;
                    else if(choices[i]==3) score[3][0] += 1;
                    else if(choices[i]==5) score[3][1] += 1;
                    else if(choices[i]==6) score[3][1] += 2;
                    else if(choices[i]==7) score[3][1] += 3;
                } else {
                    if(choices[i]==1) score[3][1] += 3;
                    else if(choices[i]==2) score[3][1] += 2;
                    else if(choices[i]==3) score[3][1] += 1;
                    else if(choices[i]==5) score[3][0] += 1;
                    else if(choices[i]==6) score[3][0] += 2;
                    else if(choices[i]==7) score[3][0] += 3;
                }
            }
        }
        
        for(int i=0; i<score.length; i++) {
            if(score[i][0] >= score[i][1]) {
                if(i==0) answer += "R";
                else if(i==1) answer += "C";
                else if(i==2) answer += "J";
                else answer += "A";
            } else {
                if(i==0) answer += "T";
                else if(i==1) answer += "F";
                else if(i==2) answer += "M";
                else answer += "N";
            }
        }
        
        return answer;
    }
}