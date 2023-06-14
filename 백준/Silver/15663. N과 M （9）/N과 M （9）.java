import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static int n;
	public static int m;
	public static HashSet<String>list;
	public static boolean[]check;
	public static int[]arr;
    public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    n=sc.nextInt();
	    m=sc.nextInt();
	    sc.nextLine();
	    arr=new int[n];
	    check=new boolean[n];
	    for(int i=0;i<n;i++) {
	    	arr[i]=sc.nextInt();
	    }
	    Arrays.sort(arr);
	    list=new HashSet<>();
	    perm(0,"");
	    
    }
    public static void perm(int dept,String str) {
    	if(dept==m) {
    		if(!list.contains(str)) {
    			System.out.println(str);
    			list.add(str);
    		}
    		return;
    	}
    	for(int i=0;i<n;i++) {
    		if(!check[i]) {
    			check[i]=true;
    			perm(dept+1,str+arr[i]+""+" ");
    			check[i]=false;
    		}
    	}
    	
    }
}
