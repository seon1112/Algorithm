class Solution {
    public long solution(int n) {
        long answer = 0;
        int a=1;
		 int b=2;
		 
		 if(n==1) {
			 answer=1;
		 }else if(n==2) {
			 answer=2;
		 }else {
			 int temp=0;
			 for(int i=3;i<=n;i++) {
				 temp =b%1234567;
				 b=a%1234567+b%1234567;
				 a=temp;
				 
			 }
			 answer=b%1234567;
			 
		 }
        return answer;
    }
}