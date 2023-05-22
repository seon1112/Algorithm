class Solution {
public static int answer;
    public int solution(int n) {
        int [][]arr=new int[n][n];
		paint(0,n,arr);
        return answer;
    }
    //한 행에 하나만 배치할 수 있으로 한 행씩 이동하면서 비교
	public static void paint(int row,int n,int[][]arr) {
		//row가 n에 도달하면
		if(row==n) {
			answer++;
			return;
		}
		//col
		for(int col=0;col<n;col++) {
			if(check(row,col,n,arr)) {		
				arr[row][col]=1;			//퀸이 배치된 위치
				paint(row+1,n,arr);			//다음행으로 이동
				arr[row][col]=0;			//백트래킹
			}
			
		}
	}
	//선택한 열에 퀸이 있는지 체크
	public static boolean check(int row,int col,int n,int [][]arr) {
		//같은열
		for(int i=0;i<n;i++) {
			if(arr[i][col]==1) {
				return false;
			}
		}
		//오른쪽 대각선
		for(int i=-n;i<n;i++) {
			if(row+i>=0&&row+i<n&&col+i>=0&&col+i<n) {
				if(arr[row+i][col+i]==1) {
					return false;
				}
			}
		}
		//왼쪽 대각선
		for(int i=-n;i<n;i++) {
			if(row-i>=0&&row-i<n&&col+i>=0&&col+i<n) {
				if(arr[row-i][col+i]==1) {
					return false;
				}
			}
		}
		return true;
	}
}