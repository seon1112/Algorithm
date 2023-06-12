import java.util.Scanner;
public class Main {
	public static boolean []paint;
    public static void main(String[] args) {
    	Scanner sc= new Scanner(System.in);
    	int n=sc.nextInt();
    	int m=sc.nextInt();
    	paint=new boolean[n+1];
    	for(int i=1;i<=n;i++) {
    		paint[i]=true;
    		check(n,m,1,i);
    		paint[i]=false;
    	}
      }
    public static void check(int n,int m,int k,int a) {
    	if(k>=m) {
    		for(int i=1;i<=n;i++) {
    			if(paint[i]) {
    				System.out.print(i+" ");
    			}
    		}
    		System.out.println();
    		return;
    	}
    	for(int i=a;i<=n;i++) {
    		if(!paint[i]) {
    			paint[i]=true;
    			check(n,m,k+1,i+1);
    			paint[i]=false;
    		}
    	}
    }
    
}
