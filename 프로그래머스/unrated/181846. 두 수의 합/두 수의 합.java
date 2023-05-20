import java.math.BigDecimal;
class Solution {
    public String solution(String a, String b) {
        String answer = "";
        BigDecimal a1 = new BigDecimal(a);
        BigDecimal b1 = new BigDecimal(b);
        BigDecimal sum = a1.add(b1);
        
        answer = sum.toString();
        return answer;
    }
}