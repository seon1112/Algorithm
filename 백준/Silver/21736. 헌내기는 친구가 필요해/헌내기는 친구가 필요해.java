


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int []dx= {1,-1,0,0};
	public static int []dy= {0,0,1,-1};
	public static String [][]arr;
	public static boolean [][]check;
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
		
		check=new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j].equals("I")) {
					perm(i,j);
					break;
				}
			}
		}
		String answer="TT";
		if(count!=0) {
			answer=count+"";
		}
		System.out.println(answer);
	}
	public static void perm(int x,int y) {
		Queue<int[]>que=new LinkedList<int[]>();
		int []node= {x,y};
		que.add(node);
		check[x][y]=true;
		
		while(!que.isEmpty()) {
			int[]f=que.poll();
			x=f[0]; y=f[1];
			
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(nx<0||ny<0||nx>=n||ny>=m)continue;
				if(!check[nx][ny]&&arr[nx][ny].equals("P")) {
					count++;
					check[nx][ny]=true;
					que.add(new int[] {nx,ny});
				}else if(!check[nx][ny]&&arr[nx][ny].equals("O")) {
					check[nx][ny]=true;
					que.add(new int[] {nx,ny});
				}
			}
		}
		
		
	}
	
	
	
	
}