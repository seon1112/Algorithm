import java.util.*;
class Solution {
    public static int dx[]= {-1,1,0,0};
	public static int dy[]= {0,0,-1,1};
	public static int answer=0;
    public int solution(int[][] maps) {
       int n=maps.length;
		int m=maps[0].length;
		dfs(maps,n,m,0,0);
		return answer;
    }
    
    public static class node{
		int x; int y;
		public node(int x,int y) {
			this.x=x;
			this.y=y;
		}
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
	
	}
	public static void dfs(int[][]maps,int n,int m,int x,int y) {
		Queue<node>que=new LinkedList<>();
		que.add(new node(0,0));
		
		while(!que.isEmpty()) {
			node no=que.poll();
			 x=no.getX();
			 y=no.getY();
			 boolean flag=false;
			 for(int i=0;i<4;i++) {
				 int nx=x+dx[i];
				 int ny=y+dy[i];
				 
				 if(nx<0||ny<0||nx>=n||ny>=m) {
					 continue;
				 }
				 if(maps[nx][ny]==1) {
					 maps[nx][ny]=maps[x][y]+1;
					 que.add(new node(nx, ny));
					 flag=true;
				 }
			 }
             
		}
		
		answer=maps[n-1][m-1];
	    if(answer==1){
            answer=-1;
        }
		
	}
	
}