import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
       Arrays.sort(citations);
		
		for(int i=citations.length-1;i>=0;i--) {
			int n =citations[i];
			int m =citations.length-i;
			if(i==citations.length-1) {
				if(n==0) {
					answer=0;
				}else if(n>=1) {
					answer=1;
				}
			}else {
				if(n>=m) {
					answer=m;
					continue;
				}else {
					break;
				}
				
			}
		}
        return answer;
    }
}