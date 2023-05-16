class Solution {
    public int solution(int n) {
        int answer = 0;
        int count[]=new int[n+1];
        count[1]=1;
        count[2]=2;
        //count[3]=3
        for(int i=3;i<n+1;i++){
            count[i]=(count[i-1]+count[i-2])% 1000000007;
            //한칸 이동하는 경우의 수 1개
            //두칸 이동하는 경우의 수 1개
        }
        answer=count[n];
        return answer;
    }
}