class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int sum=0; int pow=1;
        for(int i:num_list){
            sum+=i;
            pow*=i;
        }
        if(Math.pow(sum,2)>pow){
            answer=1;
        }
        return answer;
    }
}