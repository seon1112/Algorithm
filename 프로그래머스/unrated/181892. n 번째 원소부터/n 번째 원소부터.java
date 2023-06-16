class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = {};
        answer=new int[num_list.length-n+1];
        int a=0;
        for(int i=n-1;i<num_list.length;i++){
            answer[a]=num_list[i];
            a++;
        }
        return answer;
    }
}