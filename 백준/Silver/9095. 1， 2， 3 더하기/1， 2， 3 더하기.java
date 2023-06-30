


import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int []arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		int []check=new int[12];
		check[1]=1;	//1
		check[2]=2; //1+1; 2
		check[3]=4; //1+1+1 2+1 1+2 3   	/
		check[4]=7; //1+1+1+1 2+1+1 1+2+1 1+1+2 1+3 3+1 2+2	//  6 1
		int k=0;
		for(int i=4;i<12;i++) {
			check[i]=(check[i-2]) +(check[i-1])+check[i-3];
		}
		for(int i=0;i<n;i++) {
			System.out.println(check[arr[i]]);
		}
		
	}

}