import java.util.*;
class Solution {
    public static int tot;
	public static boolean []check;
    public int solution(int n, int[][] wires) {
        int answer = -1;
        ArrayList<int[]>list=new ArrayList<>();
		check=new boolean[n+1];
		tot=1000;
		for(int i=0;i<wires.length;i++) {
			list.add(wires[i]);
		}
		for(int i=0;i<wires.length;i++) {
			int a=wires[i][0];
			int b=wires[i][1];
			list.remove(i);
			Arrays.fill(check, false);
			perm(list,a,b);
			list.add(i, wires[i]);
		}
		answer=tot;
        return answer;
    }
    public static void perm(ArrayList<int[]> list,int a,int b) {
		int tot_a=0;
		int tot_b=0;
		
		Queue<Integer>que=new LinkedList<>();
		check[a]=true;
		que.add(a);
		
		while(!que.isEmpty()) {
			int k=que.poll();
			for(int[] arr:list) {
				if(arr[0]==k || arr[1]==k) {
					for(int i:arr) {
						if(check[i]==false) {
							check[i]=true;
							que.add(i);
						}
					}
				}
			}
		}
		for(int i=0;i<check.length;i++) {
			if(check[i]) {
				tot_a++;
			}
		}
		Arrays.fill(check, false);
		que.add(b);
		check[b]=true;
		
		while(!que.isEmpty()) {
			int k=que.poll();
			for(int[] arr:list) {
				if(arr[0]==k|| arr[1]==k) {
					for(int i:arr) {
						if(check[i]==false) {
							check[i]=true;
							que.add(i);
						}
					}
				}
			}
		}
		for(int i=0;i<check.length;i++) {
			if(check[i]) {
				tot_b++;
			}
		}
		tot=Math.min(tot, Math.abs(tot_a-tot_b));
	}
}