import java.util.Scanner;

public class Main {
	public static int [][]arr;
	public static int blue;	//1
	public static int white;//0
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		arr=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		check(0,n,0,n);
		System.out.println(white);
		System.out.println(blue);
	}
	 public static void check(int xStart, int xEnd, int yStart, int yEnd) {
	        int color = arr[xStart][yStart];
	        boolean isMonochrome = true;
	        for (int i = xStart; i < xEnd; i++) {
	            for (int j = yStart; j < yEnd; j++) {
	                if (arr[i][j] != color) {
	                    isMonochrome = false;
	                    break;
	                }
	            }
	            if (!isMonochrome) {
	                break;
	            }
	        }

	        if (isMonochrome) {
	            if (color == 1) {
	                blue++;
	            } else {
	                white++;
	            }
	        } else {
	            int xMid = (xStart + xEnd) / 2;
	            int yMid = (yStart + yEnd) / 2;
	            check(xStart, xMid, yStart, yMid);
	            check(xMid, xEnd, yStart, yMid);
	            check(xStart, xMid, yMid, yEnd);
	            check(xMid, xEnd, yMid, yEnd);
	        }
	    }
}