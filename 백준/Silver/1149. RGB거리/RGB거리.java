import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int n;
    public static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        // 시작하기
        int count[][]=new int[n][3];
        count[0][0]=arr[0][0];
        count[0][1]=arr[0][1];
        count[0][2]=arr[0][2];
        
        for(int i=1;i<n;i++) {
        	count[i][0]=Math.min(count[i-1][1], count[i-1][2])+arr[i][0];
        	count[i][1]=Math.min(count[i-1][0], count[i-1][2])+arr[i][1];
        	count[i][2]=Math.min(count[i-1][1], count[i-1][0])+arr[i][2];
        }
        answer=Math.min(Math.min(count[n-1][0], count[n-1][1]), count[n-1][2]);
        System.out.println(answer);
    }
}
