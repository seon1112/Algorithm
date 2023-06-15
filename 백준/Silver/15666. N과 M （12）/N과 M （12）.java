import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static int[]arr;
	public static int n;
	public static int m;
	public static HashSet<String>set;
    public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		set=new HashSet<>();
		Arrays.sort(arr);
		perm(0,0,"");
		
    }
    public static void perm(int k,int r, String str) {
    	if(r==m) {
    		if(!set.contains(str)) {
    			set.add(str);
    			System.out.println(str);
    		}
    		return;
    	}
    	
    	for(int i=k;i<n;i++) {
    		perm(i,r+1,str+arr[i]+""+" ");
    	}
    }
}
