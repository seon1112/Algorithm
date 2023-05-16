import java.util.*;
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int count[][]=new int[land.length+1][4];
		for(int i=0;i<4;i++) {
			count[0][i]=land[0][i];				//1,2,3,5
		}
		for(int i=1;i<land.length;i++) {
			for(int j=0;j<4;j++) {
				for(int k=0;k<4;k++) {
					if(k!=j) {
						count[i][j]=Math.max(count[i-1][k],count[i][j] );
						//1,2,3,5
						//10,11,12,11
						//16,15,13,13
					}
				}
				count[i][j]+=land[i][j];
				
			}
			
		}
		for(int i=0;i<4;i++) {
			answer=Math.max(count[land.length-1][i],answer);
		}

        return answer;
    }
}