import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();				//10
		int []arr=new int[n+1];
		int []cal= {2,3};
		arr[1]=0;
		
		for(int i=2;i<n+1;i++){
			arr[i]=arr[i-1]+1;
			for(int j=0;j<2;j++) {
				if(i%cal[j]==0) {
					arr[i]=Math.min(arr[i], arr[i/cal[j]]+1);
				}
			}
		}
		int answer=arr[n];
		System.out.println(answer);
	}

}