class Solution {
        public int[] solution(int n) {
            int[] answer = {};
            int size=n*(n+1)/2;
            int m=n;
		answer=new int[size];
		int[][]arr=new int[n][n];
		arr[0][0]=1;   //시작을 1으로
		int row=0;
		int col=0;
		while(n>0) {
			//내려가기
			for(int i=0;i<n;i++) {
				if(row==0) {
					row++;continue;
				}
				arr[row][col]=arr[row-1][col]+1;  
				row++;
			}
			row--;
			col++;
			n--;
			if(n==0)break;
			
			//옆으로가기
			for(int j=0;j<n;j++) {
				arr[row][col]=arr[row][col-1]+1;
				col++;
			}
			row--;
			col--;
			col--;
			n--;
			if(n==0)break;
			
			//대각선으로 가기
			for(int k=0;k<n;k++) {
				arr[row][col]=arr[row+1][col+1]+1;
				row--;
				col--;
			}
			row++;
			row++;
			col++;
			n--;
		
			if(n==0)break;
		
		}
	
		int a=0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]!=0) {
					answer[a]=arr[i][j];
					a++;
				}
			}
		}
		
        
        return answer;
    }
}