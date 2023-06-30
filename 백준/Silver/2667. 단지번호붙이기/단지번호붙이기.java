


import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int []dx= {1,-1,0,0};
	public static int []dy= {0,0,1,-1};
	public static String [][]arr;
	public static boolean [][]check;
	public static int n;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		sc.nextLine();
		arr=new String[n][n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextLine().split("");
		}
		check=new boolean[n][n];
		ArrayList<Integer>list=new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j].equals("1")&&!check[i][j]) {
					int tot=perm(i,j);
					list.add(tot);
				}
			}
		}
		list.sort(Comparator.naturalOrder());
		System.out.println(list.size());
		for(int i:list) {
			System.out.println(i);
		}
	}
	public static int perm(int x,int y) {
		int tot=1;
		Queue<int[]>que=new LinkedList<int[]>();
		int []node= {x,y};
		check[x][y]=true;
		que.add(node);
		
		while(!que.isEmpty()) {
			int[]f=que.poll();
			x=f[0]; y=f[1];
			
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(nx<0||ny<0||nx>=n||ny>=n)continue;
				if(!check[nx][ny]&&arr[nx][ny].equals("1")) {
					tot++;
					check[nx][ny]=true;
					que.add(new int[]{nx,ny});
				}
			}
		}
		return tot;
	}
}