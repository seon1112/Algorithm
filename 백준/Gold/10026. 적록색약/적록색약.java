

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static String [][]arr;
	public static int []dx= {1,-1,0,0};
	public static int []dy= {0,0,1,-1};
	public static int N;
	public static int answer1;
	public static int answer2;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		sc.nextLine();
		arr=new String[N][N];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextLine().split("");
		}
		 boolean [][]check=new boolean[N][N];
		 boolean [][]check2=new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!check[i][j]) {
					perm(i,j,0,check);
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!check2[i][j]) {
					perm(i,j,1,check2);
				}
			}
		}
		
		System.out.print(answer1+" "+answer2);
	 }
	//R B G
	public static void perm(int x,int y,int col,boolean [][]check) {
		Queue<int []>que=new LinkedList<int []>();
		int[]node= {x,y};
		String color=arr[x][y];
		que.add(node);
		if(col==1 &&color.equals("G")) {
			color="R";
		}
		while(!que.isEmpty()) {
			int[]n=que.poll();
			x=n[0];
			y=n[1];
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx<0||ny<0||nx >= N ||ny >= N) {
					continue;
				}
				if(col==1 &&arr[nx][ny].equals("G")) {
					arr[nx][ny]="R";
				}
				if(!check[nx][ny]&&arr[nx][ny].equals(color)) {
					check[nx][ny]=true;
					que.add(new int[] {nx,ny});
				}
			}
		}
		if(col==0) {
			answer1++;
		}else {
			answer2++;
		}
		
	}
}