import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int n;
	public static int m;
	public static int answer;
	public static int[]dx= {-1,1,0,0};
	public static int[]dy = {0,0,-1,1};
    public static void main(String[] args) {
    	//0은 빈 칸, 1은 벽, 2는 바이러스
    	Scanner sc=new Scanner(System.in);
    	n=sc.nextInt();  //세로
    	m=sc.nextInt();  //가로
    	int [][]arr=new int[n][m];
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			arr[i][j]=sc.nextInt();
    		}
    		sc.nextLine();
    	}
    	answer=0; //안전영역크기
    	makeWall(0,arr,0,0);
    	System.out.println(answer);
    }
    //안전벽 설치
    public static void makeWall(int w,int [][]arr,int x,int y) {
    	if(w==3) {
    		int [][]tempArr=spreadVirus(arr);
    		int count=safeZone(tempArr);
    		answer=Math.max(answer, count);
    		return;
    	}
    	for(int i=x;i<n;i++) {
    		for(int j=y;j<m;j++) {
    			if(arr[i][j]==0) {
    				arr[i][j]=1;
    				makeWall(w+1,arr,i,j+1);
    				arr[i][j]=0;
    			}
    		}
    		y=0;
    	}
    }
 // 바이러스 퍼짐
    public static int[][] spreadVirus(int[][] arr) {
        int[][] tempArr = new int[n][m];  // 바이러스 퍼뜨린 후의 배열을 저장하기 위한 임시 배열
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tempArr[i][j] = arr[i][j];
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tempArr[i][j] == 2) {
                	
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int x = position[0];
            int y = position[1];
            for (int k = 0; k < 4; k++) {
                int newX = x + dx[k];
                int newY = y + dy[k];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && tempArr[newX][newY] == 0) {
                    tempArr[newX][newY] = 2;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
       return tempArr;
    }

    // 안전 지역 확인
    public static int safeZone(int[][] arr) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}

