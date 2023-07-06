
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int[]arr= {1,-1,2};
	public static int n;
	public static int k;
	public static int []check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt(); // 언니의 위치
        k=sc.nextInt(); //동생의 위치
        check=new int[100001];
        int answer=0;
        if(n==k) {
        	answer=0;
        }else {
        	answer=perm(n);
        }
        
        System.out.println(answer);
    }
    public static int perm(int n) {
    	Queue<Integer>que=new LinkedList<Integer>();
    	que.add(n);
    	while(!que.isEmpty()) {
    		int x=que.poll();
    		for(int i=0;i<3;i++) {
    			int nx;
    			if(i==2) {
    				nx=x*arr[i];
    			}else {
    				nx=x+arr[i];
    			}
    			if(nx>=100001||nx<0)continue;
    			if(check[nx]==0) {
    				check[nx]=check[x]+1;
    				que.add(nx);
    			}
    			if(check[k]!=0) {
    				break;
    			}
    		}
    	}
    	return check[k];
    }
}
