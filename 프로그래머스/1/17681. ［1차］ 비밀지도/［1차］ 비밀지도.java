class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] map1 = new String[n];
        String[] map2 = new String[n];
        
        for(int i=0; i<arr1.length; i++) {
            String s1 = "";
            int num1 = arr1[i];
            
            while(num1 > 1) {
                s1 += num1 % 2;
                num1 /= 2;
            }
            s1 += num1;
            
            int len1 = s1.length();
            if(s1.length() < n) {
                for(int j=0; j<n-len1; j++) {
                    s1 += '0';
                }
            }
            
            StringBuffer sb1 = new StringBuffer(s1);
            map1[i] = sb1.reverse().toString();
        }
        
        for(int i=0; i<arr2.length; i++) {
            String s2 = "";
            int num2 = arr2[i];
            
            while(num2 > 1) {
                s2 += num2 % 2;
                num2 /= 2;
            }
            s2 += num2;
            
            int len2 = s2.length();
            if(s2.length() < n) {
                for(int j=0; j<n-len2; j++) {
                    s2 += '0';
                }
            }
            
            StringBuffer sb2 = new StringBuffer(s2);
            map2[i] = sb2.reverse().toString();
        }
        
        for(int r=0; r<n; r++) {
            answer[r] = "";
            for(int c=0; c<n; c++) {
                if(map1[r].charAt(c) == '1' || map2[r].charAt(c) == '1') answer[r] += "#";
                else answer[r] += " ";
            }
        }
        
        return answer;
    }
}