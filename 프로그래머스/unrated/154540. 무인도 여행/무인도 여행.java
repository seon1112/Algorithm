import java.util.*;

class Solution {
    public static int[]dx= {-1,1,0,0}; //상하좌우
public static int[]dy= {0,0,-1,1};
public static boolean[][]bol;
public static ArrayList<Integer>list;
    public int[] solution(String[] maps) {
        int[] answer = {};
        String[][]map=new String[maps.length][maps[0].length()];
		bol=new boolean[maps.length][maps[0].length()];
		list=new ArrayList<>();
		//2차 배열로 만들기
		for(int i=0;i<maps.length;i++) {
			for(int j=0;j<maps[0].length();j++) {
				map[i][j]=maps[i].charAt(j)+"";
			}
		}
		for(int i=0;i<maps.length;i++) {
			for(int j=0;j<maps[0].length();j++) {
				if(bol[i][j]||map[i][j].equals("X")) {
					continue;
				}
				bol[i][j]=true;
				int total=Integer.parseInt(map[i][j]);
				check(map,i,j,total);
			}
		}
		if(list.isEmpty()) {
			answer=new int[1];
			answer[0]=-1;
		}else {
			answer=new int[list.size()];
			list.sort(Comparator.naturalOrder());
			for(int i=0;i<list.size();i++) {
				answer[i]=list.get(i);
			}
		}
        return answer;
    }
    public static void check(String[][]map,int x,int y,int total) {
		Queue<Node>que=new LinkedList<>();
		que.add(new Node(x,y));
		
		while(!que.isEmpty()) {
			Node node=que.poll();
			x=node.getX();
			y=node.getY();
			
			for(int i=0;i<4;i++) {
				int nx=x+ dx[i];
				int ny=y+ dy[i];
				
				if(nx<0||nx>=map.length||ny<0||ny>=map[0].length||bol[nx][ny]||map[nx][ny].equals("X")) {
					continue;
				}
				total+=Integer.parseInt(map[nx][ny]);
				bol[nx][ny]=true;
				que.add(new Node(nx,ny));
				
			}
			
		}
		list.add(total);
		total=0;
		return;
		
	}
	public static class Node {
		 int x;
		 int y;
		 Node(int x, int y){
			 this.x=x;
			 this.y=y;
		 }
		int getX() {
			return x;
		}
		int getY() {
			return y;
		}
	}
}