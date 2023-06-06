import java.util.*;
class Solution {
  public static int []xmove= {2,0,-2,0,1,-1,-1,1};
	public static int []ymove= {0,2,0,-2,-1,1,-1,1};
    public int[] solution(String[][] places) {
        int[] answer = {};
        answer=new int[5];
		for(int i=0;i<places.length;i++) {
			String [][]arr=new String[5][5];
			for(int j=0;j<5;j++) {
				for(int k=0;k<5;k++) {
					arr[j][k]=places[i][j].charAt(k)+"";
				}
			}
			int k=check(arr);
			answer[i]=k;
		}
        return answer;
    }
    public static int check(String [][]arr) {
		int k=1;
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(arr[i][j].equals("P")) {
					int n=find(i,j,arr);
					if(n==0) {
						return k=0;
					}
				}
			}
		}
		return k=1;
		
	}
	
	public static int find(int x,int y,String [][]arr){
		int n=1;
		if(x+1<5 && arr[x+1][y].equals("P")) {
			return n=0;
		}
		if(y+1<5&&arr[x][y+1].equals("P")) {
			return n=0;
		}
		if(x-1>=0&&arr[x-1][y].equals("P")) {
			return n=0;
		}
		if(y-1>=0&&arr[x][y-1].equals("P")) {
			return n=0;
		}
		
		for(int i=0;i<4;i++) {		//22
			int dx=x+xmove[i];			
			int dy=y+ymove[i];			
			if(dx<0||dy<0||dx>4||dy>4) {		//33
				continue;
			}
			if(arr[dx][dy].equals("P")) {
				if(i==0) {
					if(!arr[x+1][dy].equals("X")) return n=0;
				}else if(i==1) {
					if(!arr[dx][y+1].equals("X")) return n=0;
				}else if(i==2) {
					if(!arr[dx+1][dy].equals("X")) return n=0;
				}else {
					if(!arr[dx][dy+1].equals("X")) return n=0;
				}
				
			}
		}
		
		for(int i=4;i<8;i++) {		//-11 1-1
			int dx=x+xmove[i];
			int dy=y+ymove[i];
			if(dx<0||dy<0||dx>4||dy>4) {
				continue;
			}
			if(arr[dx][dy].equals("P")) {
				if(!(arr[dx][y].equals("X")&&arr[x][dy].equals("X"))) {
					return n=0;
				}
			}
		}
		
		return n=1;
	}
}