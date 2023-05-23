import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public static int []dx= {-1,1,0,0};		//x축 이동
	public static int []dy= {0,0,-1,1};		//y축 이동
	public static int answer = 0;
    public int solution(String[] maps) {
     int [][]check=new int[maps.length][maps[0].length()]; 
		String [][]map=new String[maps.length][maps[0].length()];
		int []arr=new int[6];
		for(int i=0;i<maps.length;i++) {
			for(int j=0;j<maps[0].length();j++) {
				map[i][j]=maps[i].charAt(j)+"";
				if(map[i][j].equals("S")) {
					arr[0]=i; arr[1]=j;					//0,1 ==출발
				}else if(map[i][j].equals("L")) {
					arr[2]=i; arr[3]=j;					//2,3 ==레버
				}else if(map[i][j].equals("E")) {
					arr[4]=i; arr[5]=j;					//4,5 ==출구
				}
			}
		}
	

		find(map,arr,check);
		if(answer==0) {
			answer=-1;
		}
        return answer;
    }
    //레버찾기
	public static void find(String[][] map, int[] arr, int[][] check) {
	    Queue<Node> que = new LinkedList<>();
	    que.add(new Node(arr[0],arr[1]));
	    
	    while(!que.isEmpty()) {
	    	Node node=que.poll();
	    	int x=node.getX();
	    	int y=node.getY();
	    	
	    	if(x==arr[2]&&y==arr[3]) {
	    		int n=check[x][y];
	    		for (int i = 0; i < check.length; i++) {
                    Arrays.fill(check[i], 0);
                }
	    		check[x][y]=n;
	    		exit(map,arr,check);
	    		return;
	    	}
	    	for(int i=0;i<4;i++) {
	    		int nx=x+dx[i];
	    		int ny=y+dy[i];
	    		if(nx<0||ny<0||nx>=map.length||ny>=map[0].length) 	continue;
		    	if(map[nx][ny].equals("X"))	continue;
		    	if(check[nx][ny]==0) {
		    		check[nx][ny]=check[x][y]+1;
			    	que.add(new Node(nx,ny));
		    	}
		    	
		    	
	    	}
	    	
	    }
	    	
	}
	
	//레버에서 탈출구찾기
	public static void exit(String[][] map, int[] arr, int[][] check) {
		 Queue<Node> que = new LinkedList<>();
		    que.add(new Node(arr[2],arr[3]));
		    
		    while(!que.isEmpty()) {
		    	Node node=que.poll();
		    	int x=node.getX();
		    	int y=node.getY();
		    	
		    	for(int i=0;i<4;i++) {
		    		int nx=x+dx[i];
		    		int ny=y+dy[i];
		    		
		    		if(nx<0||ny<0||nx>=map.length||ny>=map[0].length) 	continue;
			    	if(map[nx][ny].equals("X"))	continue;
			    	if(check[nx][ny]==0) {
			    		check[nx][ny]=check[x][y]+1;
				    	que.add(new Node(nx,ny));
			    	}
			    	
			    	
		    	}
		    	
		    }
		    	
		answer=check[arr[4]][arr[5]];
	
	
		
	}
	static class Node {
        private int x;
        private int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}