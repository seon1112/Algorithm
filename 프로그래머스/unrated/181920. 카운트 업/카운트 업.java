class Solution {
    public int[] solution(int start, int end) {
        int[] answer = {};
        answer=new int[end-start+1];
        int a=0;
        for(int i=start;i<=end;i++){
            answer[a]=i;
            a++;
        }
        return answer;
    }
}