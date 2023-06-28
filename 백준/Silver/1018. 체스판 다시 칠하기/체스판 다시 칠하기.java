import java.util.Scanner;

public class Main {
	public static String [][]arr;
	public static int n;
	public static int m;
	public static int answer;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		 n = sc.nextInt();
		 m = sc.nextInt();
		sc.nextLine(); // 줄 바꿈 문자 제거

		arr = new String[n][m];
		for (int i = 0; i < n; i++) {
		    String line = sc.nextLine();
		    arr[i] = line.split("");
		}
		answer=300000;
		for(int i=0;i<n-7;i++) {
			for(int j=0;j<m-7;j++) {
				perm("W",0,i,j);
				perm("B",0,i,j);
			}
		}
		
		
		System.out.println(answer);
		
	}
	public static void perm(String start,int tot,int x,int y) {
		//String start=arr[x][y];
		for(int i=x;i<x+8;i++) {
			String str=start;
			for(int j=y;j<y+8;j++) {
				if(!arr[i][j].equals(str)) {
					tot++;
				}
				if(str.equals("B")) {
					str="W";
				}else {
					str="B";
				}
			}
			if(start.equals("B")) {
				start="W";
			}else {
				start="B";
			}
		}
		//System.out.println(tot);
		answer=Math.min(answer, tot);
	}
}