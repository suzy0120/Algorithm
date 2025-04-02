public class Solution {
    public String solution(String p) {
        if (p.isEmpty()) return "";

        // 균형잡힌 u, 나머지 v 나누기
        int open = 0, close = 0, i = 0;
        do {
            if (p.charAt(i) == '(') open++;
            else close++;
            i++;
        } while (open != close);

        String u = p.substring(0, i);
        String v = p.substring(i);

        // 올바른 괄호인지 검사
        if (isCorrect(u)) {
            return u + solution(v);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(solution(v));
            sb.append(")");
            for (int j = 1; j < u.length() - 1; j++) {
                sb.append(u.charAt(j) == '(' ? ')' : '(');
            }
            return sb.toString();
        }
    }

    private boolean isCorrect(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else {
                count--;
                if (count < 0) return false;
            }
        }
        return true;
    }
}