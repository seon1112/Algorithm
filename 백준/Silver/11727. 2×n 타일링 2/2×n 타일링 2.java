import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	int n=sc.nextInt();  
    	int []count=new int[Math.max(n + 1, 3)];
    	count[1]=1;
    	count[2]=3;
    	for(int i=3;i<n+1;i++) {
    		count[i]=(count[i-2]*2+count[i-1])%10007;
    	}
    	System.out.println(count[n]);
    }
}