class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int sum=0; int sum2=0;
        for(int i=0;i<num_list.length;i++){
            if(i%2==0){
                sum+=num_list[i];
            }else{
                sum2+=num_list[i];
            }
        }
        answer=(int)Math.max(sum,sum2);
        return answer;
    }
}