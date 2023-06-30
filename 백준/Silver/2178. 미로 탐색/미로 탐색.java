


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int []dx= {1,-1,0,0};
	public static int []dy= {0,0,1,-1};
	public static String [][]arr;
	public static int [][]check;
	public static int n;
	public static int m;
	public static int count;
	public static void main(String[] args) {
		//O는 빈 공간, X는 벽, I는 도연이, P는 사람이다. I가
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		sc.nextLine();
		arr=new String[n][m];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextLine().split("");
		}
		
		check=new int[n][m];
		check[0][0]=1;
		perm(0,0);
		
		System.out.println(check[n-1][m-1]);
	}
	public static void perm(int x,int y) {
		Queue<int[]>que=new LinkedList<int[]>();
		int []node= {x,y};
		que.add(node);
		
		while(!que.isEmpty()) {
			int[]f=que.poll();
			x=f[0]; y=f[1];
			
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(nx<0||ny<0||nx>=n||ny>=m)continue;
				if(check[nx][ny]==0&&arr[nx][ny].equals("1")) {
					check[nx][ny]=check[x][y]+1;
					que.add(new int[] {nx,ny});
				}
			}
		}
		
	}
	
	
	
	
}