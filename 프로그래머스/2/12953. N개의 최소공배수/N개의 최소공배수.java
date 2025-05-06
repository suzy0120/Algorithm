class Solution {
    public int solution(int[] arr) {
        int lcm = arr[0];
        
        for(int i=1; i<arr.length; i++) {
            lcm = getLCM(lcm, arr[i]);
        }
        
        return lcm;
    }

    // 두 수의 최소공배수 구하기
    private int getLCM(int a, int b) {
        return a * b / getGCD(a, b);
    }

    // 두 수의 최대공약수 (유클리드 호제법)
    private int getGCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        
        return a;
    }
}