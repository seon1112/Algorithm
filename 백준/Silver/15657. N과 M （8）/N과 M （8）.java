import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
	public static boolean[][]check;
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
    	check=new boolean[m][n];
    	perm(n,m,arr,0,0);
      }
    public static void perm(int n,int m,int []arr,int r,int k) {
    	if(r==m) {
    		for(int j=0;j<m;j++) {
    			for(int i=0;i<n;i++) {{
        			if(check[j][i]) {
        				System.out.print(arr[i]+" ");
        			}
        		}
    		}
    		
    		}
    		System.out.println("");
    		return;
    	}
    	for(int i=k;i<n;i++) {
    		if(!check[r][i]) {
    			check[r][i]=true;
    			perm(n,m,arr,r+1,i);
    			check[r][i]=false;
    		}
    	}
    }
 
}
