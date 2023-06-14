import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int n=sc.nextInt();
	    sc.nextLine();
	    int[][]arr=new int[n][n];
	    for(int i=0;i<n;i++) {
	    	for(int j=0;j<i+1;j++) {
	    		arr[i][j]=sc.nextInt();
	    	}
	    	sc.nextLine();
	    }

	    //----------------------------
	    int[][]count=new int[n][n];
	    count[0][0]=arr[0][0];
	    for(int i=0;i<n-1;i++) {
	    	for(int j=0;j<i+1;j++) {
	    		for(int k=j;k<j+2;k++) {
	    			count[i+1][k]=Math.max(count[i+1][k], count[i][j]+arr[i+1][k]);
	    		}
	    	}
	    }
	    int max=0;
	    for(int i=0;i<n;i++) {
	    	max=Math.max(max, count[n-1][i]);
	    }
	    System.out.println(max);
    }
}
