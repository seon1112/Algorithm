class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        answer=new int[prices.length];
        
        for(int i=0;i<prices.length;i++){
            if(i==prices.length-1){
                answer[i]=0;
                break;
            }
            boolean flag=true;
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]<prices[i]){
                    answer[i]=j-i;
                    flag=false;
                    break;
                }
            }
            if(flag){
                answer[i]=prices.length-i-1;
            }
            
        }
        return answer;
    }
}