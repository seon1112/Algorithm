


import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int []dx= {1,-1,0,0};
	public static int []dy= {0,0,1,-1};
	public static boolean [][]check;
	public static int [][]arr;
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        int T = scanner.nextInt();
	        scanner.nextLine();
	        ArrayList<Integer>list=new ArrayList<Integer>();
	        for (int i = 0; i < T; i++) {
	        	int answer=0;
	            int M = scanner.nextInt();
	            int N = scanner.nextInt();
	            int K = scanner.nextInt();
	            scanner.nextLine();
	            check=new boolean[N][M];
	            arr = new int[N][M];
	            for (int j = 0; j < K; j++) {
	                int X = scanner.nextInt();
	                int Y = scanner.nextInt();
	        
	                arr[Y][X] = 1;
	                scanner.nextLine();
	            }
	           for(int k=0;k<N;k++) {
	        	   for(int h=0;h<M;h++) {
	        		   if(arr[k][h]==1 && !check[k][h]) {
	        			   check[k][h]=true;
	        			  int tot= perm(k,h,N,M);
	        			 if(tot>0) {
	        				 answer++;
	        			 }
	        		   }
	        	   }
	           }
	         list.add(answer);
	        }
	        
	        
	        for(int i:list) {
	        	System.out.println(i);
	        }
	}
	public static int perm(int x,int y,int N,int M) {
		int tot=1;
		Queue<int[]>que=new LinkedList<int[]>();
		que.add(new int[] {x,y});
		
		while(!que.isEmpty()) {
			int[]f=que.poll();
			x=f[0]; y=f[1];
			
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(nx<0||ny<0||nx>=N||ny>=M)continue;
				if(!check[nx][ny]&&arr[nx][ny]==1) {
					tot++;
					check[nx][ny]=true;
					que.add(new int[]{nx,ny});
				}
			}
		}
		return tot;
	}
}