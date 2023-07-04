

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int step;
	public static int snake;
	public static HashMap<Integer, Integer>stepMap;
	public static int[]go= {1,2,3,4,5,6};
	public static int answer;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        step=sc.nextInt();
        snake=sc.nextInt();
        sc.nextLine();
        stepMap =new HashMap<Integer, Integer>();
        for(int i=0;i<step+snake;i++) {
        	int n=sc.nextInt();
        	int m=sc.nextInt();
        	stepMap.put(n, m);
        	sc.nextLine();
        }
        answer=check();
        System.out.println(answer);
       
	}
	 public static int check() {
	        boolean[] visited = new boolean[101];
	        int[] dist = new int[101]; 

	        Queue<Integer> queue = new LinkedList<>();
	        visited[1] = true;
	        queue.offer(1); 

	        while (!queue.isEmpty()) {
	            int current = queue.poll(); 
	            for (int i = 0; i < 6; i++) {
	                int next = current + go[i]; 
	                if (next > 100) {
	                    next = 100;
	                }

	                if (stepMap.containsKey(next)) {
	                    next = stepMap.get(next);
	                }
	                if (!visited[next]) {
	                    visited[next] = true;
	                    dist[next] = dist[current] + 1; 
	                    queue.offer(next);
	                }
	            }
	        }

	        return dist[100]; 
	    }
	
}
