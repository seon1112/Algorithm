


import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	     int n=sc.nextInt();
	     int m=sc.nextInt();
	     sc.nextLine();
	     int []arr=new int[n];
	     for(int i=0;i<n;i++) {
	    	 arr[i]=sc.nextInt();
	     }
	     sc.nextLine();
	   
	     int start=0;
	     int end=2000000000;
	     int result=0;
	     while(start<=end) {
	    	 long tot=0;
	    	 int mid=(int)(start+end)/2;
	    	 for(int i=0;i<n;i++) {
	    		 if(arr[i]>=mid) {
	    			 tot+=arr[i]-mid;
	    		 }
	    	 }
	    	 if(tot>=(long)m) {
	    		 result=(int)Math.max(result, mid);
	    		 start=mid+1;
	    	 }else {
	    		 end=mid-1;
	    	 }
	    	 
	     }
	     System.out.println(result);
	}
}