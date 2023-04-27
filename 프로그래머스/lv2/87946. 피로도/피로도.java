class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        boolean visit[]=new boolean[dungeons.length];
		
		dfs(dungeons,visit,k);
		return max;
	}
	public static int max=0;
	public static void dfs(int [][]dungeons,boolean[] visit,int k) {
		int count=0;
		
		for(int i=0;i<visit.length;i++) {
			if(visit[i]) {
				count++;
			}
		}
		if(count>max) {
			max=count;
		}
		for(int i=0;i<dungeons.length;i++) {
			if(!visit[i]&& k>=dungeons[i][0]) {
				visit[i]=true;
				k=k-dungeons[i][1];
				dfs(dungeons,visit,k);
				k+=dungeons[i][1];
				visit[i]=false;
			}
		}
    }
}