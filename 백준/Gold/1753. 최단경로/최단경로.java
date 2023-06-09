

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static int[]sum;
	public static int V;
	public static int E;
	public static HashMap<Integer, ArrayList<int[]>>map;
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	V=sc.nextInt(); E=sc.nextInt();
    	sc.nextLine();
    	int start=sc.nextInt();
    	sc.nextLine();
    	map=new HashMap<>();
    	for(int i=0;i<E;i++) {
    		int key = sc.nextInt();   		
    		ArrayList<int[]> list = map.getOrDefault(key, new ArrayList<>());
    		list.add(new int[] {sc.nextInt(),sc.nextInt()});
    		map.put(key, list);
    	}
    	sum=new int[V+1];
    	Arrays.fill(sum, 200000);
    	sum[start]=0;
    	check(start);
    	
    	for(int i=1;i<V+1;i++) {
    		if(sum[i]==200000) {
    			System.out.println("INF");
    		}else {
    			System.out.println(sum[i]);
    		}
    	
    	}
    }
    //0 시작 1 도착 2 가중치
    public static void check(int start) {
    	PriorityQueue<int[]>que=new PriorityQueue<>((a,b)->a[1]-b[1]);
    	que.offer(new int[]{start,0});
    	while(!que.isEmpty()) {
    		int []a=que.poll();
    		int n=a[0];
    		int tot=a[1];
    		if(!map.containsKey(n)) {
     		   continue;
     	   }
    		if(sum[n]<tot) {
    			continue;
    		}
    		ArrayList<int[]>list=map.get(n);
       	   for(int[]arr:list) {
       		   int next=arr[0];  //다음 
       		   int total=arr[1]+tot; //가중치
       		   
       		   if(sum[next]>total) {
       			   sum[next]=total;
       			   que.add(new int[]{next,total});
       		   }
       		   
       	   }
    		
    	}
   
    }
}
