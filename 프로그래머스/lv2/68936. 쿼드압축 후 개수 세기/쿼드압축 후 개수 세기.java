class Solution {
    public static int[] answer = {};
    public int[] solution(int[][] arr) {
       answer=new int[2];
		int n=arr.length;
		partition(0,0,n,arr);
        return answer;
    }
    public static void partition(int row,int col,int size,int[][]arr) {
		if(colorCheck(row,col,size,arr)) {
			if(arr[row][col]==0) {
				answer[0]++;
			}else {
				answer[1]++;
			}
			return;
		}
		
		if(size==1) {
			if(arr[row][col]==0) {
				answer[0]++;
			}else {
				answer[1]++;
			}
			return;
		}
		
		partition(row,col,size/2,arr);			//2사분면
		partition(row+size/2,col,size/2,arr);	//1사분면
		partition(row,col+size/2,size/2,arr);	//3사분면
		partition(row+size/2,col+size/2,size/2,arr); //4사분면
	}
	public static boolean colorCheck(int row,int col,int size,int [][]arr) {
		int num=arr[row][col]; 
		for(int i=row;i<row+size;i++) {
			for(int j=col;j<col+size;j++) {
				if(num!=arr[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
}