import java.util.*;

public class Main {
    public static void main(String[] args) {
    	/*8
		30 40 20 30 50 60 50 60
	 * */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
       int []count=new int[n];
       for(int i=0;i<n;i++) {
    	   count[i]=1;
    	   for(int j=0;j<i;j++) {
    		   if(arr[i]>arr[j]) {
    			   count[i]=Math.max(count[i], count[j]+1);
    		   }
    	   }
       }
       int max=0;
      for(int i:count) {
    	  max=Math.max(max, i);
      }
      System.out.println(max);
    }
}
