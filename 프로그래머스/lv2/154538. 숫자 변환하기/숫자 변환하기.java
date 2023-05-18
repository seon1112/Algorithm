import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
         int answer = 0;
        if(x==y) return 0;
		 int count[]=new int[y+1];
		 int []divisors= {2,3};
		 Arrays.fill(count, -1);
		 count[x]=0;
		 
		 for(int i=x+n;i<y+1;i++) {
			 if(count[i-n]==-1) {
				 continue;
			 }
			 count[i]=count[i-n]+1;
			 
			 for(int j:divisors) {
				 int k=(i-n)*j;
				 if(k<y+1&&count[k]==-1) {
					 count[k]=count[i-n]+1;
				 }
				 if(i%j==0&&count[i/j]!=-1) {
					 count[i]=Math.min(count[i], count[i/j]+1);
				 }
			 }
			
		 }
		 answer=count[y]!=0?count[y]:-1;
        return answer;
    }
}
