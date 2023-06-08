class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = {};
        answer=new int[arr.length];
        if(k%2==1){
            for(int i=0;i<arr.length;i++){
          arr[i]*=k;
            answer[i]=arr[i];
        }
        }else{
            for(int i=0;i<arr.length;i++){
          arr[i]+=k;
                answer[i]=arr[i];
        }
        }
        
        return answer;
    }
}