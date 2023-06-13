import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
	public static boolean[]check;
    public static void main(String[] args) {
    	Scanner sc= new Scanner(System.in);
    	int n=sc.nextInt();
    	int m=sc.nextInt();   //배열의 수 
    	sc.nextLine();
    	int []arr=new int[n];
    	for(int i=0;i<n;i++) {
    		arr[i]=sc.nextInt();
    	}
    	Arrays.sort(arr);
    	check=new boolean[n];
    	ArrayList<Integer>list=new ArrayList<>();
    	perm(n,m,arr,0,list);
      }
    public static void perm(int n,int m,int []arr,int r,ArrayList<Integer>list) {
    	if(r==m) {
    		for(int i:list) {
    			System.out.print(i+" ");
    		}
    		System.out.println("");
    		return;
    	}
    	for(int i=0;i<n;i++) {
    		if(!check[i]) {
    			check[i]=true;
    			list.add(arr[i]);
    			perm(n,m,arr,r+1,list);
    			list.remove(list.size()-1);
    			check[i]=false;
    		}
    	}
    }
 
}
