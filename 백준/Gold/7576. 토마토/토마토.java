

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int [][]arr;
	public static int[]dx= {1,-1,0,0};
	public static int[]dy= {0,0,1,-1};
	public static boolean[][]check;
	public static int m;
	public static int n;
	public static int count;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		m=sc.nextInt();
		n=sc.nextInt();
		arr=new int[n][m];
		check=new boolean[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j]=sc.nextInt();
			}
			sc.nextLine();
		}
		
		int answer=0;
		Queue<ArrayList<int []>>que=new LinkedList<>();
		ArrayList<int[]>list=new ArrayList<int[]>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==1&!check[i][j]) {
					
					check[i][j]=true;
					int []node= {i,j};
					list.add(node);
					
					
				}
			}
		}
		que.add(list);
		perm(que);
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==0) {
					count=-1;
				}
			}
		}
		System.out.println(count);
	 }
	public static void perm(Queue<ArrayList<int []>>que) {
		ArrayList<int[]>list=que.poll();
		int size=list.size();
		ArrayList<int[]>list2=new ArrayList<int[]>();
		//System.out.println(size);
		for(int j=0;j<size;j++) {
			 int[]nod=list.get(j);
			 int x=nod[0];
			 int y=nod[1];
			// System.out.println(x+" / "+y);
			 for(int i=0;i<4;i++) {
				 int nx=x+dx[i];
				 int ny=y+dy[i];
				 if(nx<0||ny<0||nx>=n||ny>=m) continue;
				 if(arr[nx][ny]==0) {
					// System.out.println(nx+" / "+ny);
					 check[nx][ny]=true;
					 arr[nx][ny]=1;
					 list2.add(new int[]{nx,ny});
				 }
			 }
		}
		
		if(list2.size()!=0) {
			que.add(list2);
			count++;
			perm(que);
		}
		
	}

}