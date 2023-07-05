


import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt(); //전체 합
        int []arr=new int[n];
        for(int i=0;i<n;i++) {
        	arr[i]=sc.nextInt();
        }
    	int answer=0;
    	for(int i=n-1;i>=0;i--) {
    		int m=k/arr[i];
    		answer+=m;
    		k=k-m*arr[i];
    		if(k==0) {
    			break;
    		}
    	}
    	System.out.println(answer);
    }
}
