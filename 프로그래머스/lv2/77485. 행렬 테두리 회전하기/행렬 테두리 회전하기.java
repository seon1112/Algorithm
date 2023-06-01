import java.util.*;
class Solution {
    public static int[][]map;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
		 answer=new int[queries.length];
		 map=new int[rows][columns];
		 for(int i=0;i<rows;i++) {
			 for(int j=0;j<columns;j++) {
				  map[i][j]=((i) * columns + j+1);
				 
			 }
		 }
		 for(int i=0;i<queries.length;i++) {
			 int []arr=queries[i];
			 answer[i]=check(arr);
		 }
        return answer;
    }
    public static int check(int[]arr) {
		ArrayList<Integer>list=new ArrayList<>();
		int x1=arr[0]-1;
		int y1=arr[1]-1;
		int x2=arr[2]-1;
		int y2=arr[3]-1;
		
		int x=x1;
		int y=y1;
		int temp=0;
		int a=map[x][y];
		list.add(a);
		int tot=(x2-x1+1)*2+(y2-y1+1)*2-4;
		while(tot>0) {
			if(x==x1&&y+1>=y1&&y+1<=y2) {
				temp=map[x][y+1];
				map[x][y+1]=a;
				a=temp;
				y++;
			}else if(y==y2&&x+1<=x2) {
				temp=map[x+1][y];
				map[x+1][y]=a;
				a=temp;
				x++;
			}else if(x==x2&&y-1>=y1&&y<=y2) {
				temp=map[x][y-1];
				map[x][y-1]=a;
				a=temp;
				y--;
			}else if(y==y1&&x-1>=x1) {
				temp=map[x-1][y];
				map[x-1][y]=a;
				a=temp;
				x--;
			}
			list.add(temp);
			tot--;
		}
		int min=Collections.min(list);
		return min;
	}
}