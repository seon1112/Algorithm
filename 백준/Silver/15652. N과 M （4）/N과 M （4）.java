import java.util.Scanner;
public class Main {
	public static boolean [][]paint;
    public static void main(String[] args) {
    	Scanner sc= new Scanner(System.in);
    	int n=sc.nextInt();
    	int m=sc.nextInt();
    	paint=new boolean[m][n+1];
    	for(int i=1;i<=n;i++) {
    		paint[0][i]=true;
    		check(n,m,1,i);
    		paint[0][i]=false;
    	}
      }
    public static void check(int n,int m,int k,int a) {
    	if(k>=m) {
    		for(int j=0;j<m;j++) {
    			for(int i=1;i<=n;i++) {
        			if(paint[j][i]) {
        				System.out.print(i+" ");
        			}
        		}
    		}
    		System.out.println();
    		return;
    	}
    	for(int i=a;i<=n;i++) {
    		if(!paint[k][i]) {
    			paint[k][i]=true;
    			check(n,m,k+1,i);
    			paint[k][i]=false;
    		}
    	}
    }
    
}
