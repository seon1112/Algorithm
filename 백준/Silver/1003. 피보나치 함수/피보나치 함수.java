


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt(); //테스트 케이스 
        int[][]answer=new int[t][2];
        for(int i=0;i<t;i++) {
        	int n=sc.nextInt();
        	//0 이면 0 1이면 1 
        	int [][]arr=new int[n+1][2];
        	arr[0][0]=1;  arr[0][1]=0;
        	if(n==0) {
        		answer[i][0]=arr[n][0];
            	answer[i][1]=arr[n][1];
        		continue;
        	}
        	arr[1][0]=0;  arr[1][1]=1;
        	if(n==1) {
        		answer[i][0]=arr[n][0];
            	answer[i][1]=arr[n][1];
        		continue;
        	}
        	for(int j=2;j<=n;j++) {
        		arr[j][0]=arr[j-1][0]+arr[j-2][0];
        		arr[j][1]=arr[j-1][1]+arr[j-2][1];
        	}
        	answer[i][0]=arr[n][0];
        	answer[i][1]=arr[n][1];
        }
        for(int i=0;i<t;i++) {
        	System.out.println(answer[i][0]+" "+answer[i][1]);
        }
    	
    }
}
