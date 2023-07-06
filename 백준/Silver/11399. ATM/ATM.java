
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for(int i=0;i<n;i++) {
        	arr[i]=sc.nextInt();
        }
        int answer=0;
        Arrays.sort(arr);
        for(int i=0;i<n;i++) {
        	answer+=arr[i]*(n-i);
        }
        System.out.println(answer);
    }
}
