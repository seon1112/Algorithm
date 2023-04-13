class Solution {
    public int solution(int balls, int share) {
       int answer = 0;
        double a=1;
        double b=1;
        for(int i=0;i<share;i++){
            b*=(i+1);
            a*=balls-i;
        }
        
        answer =(int)(Math.round(a/b));
        return answer;
    }
}