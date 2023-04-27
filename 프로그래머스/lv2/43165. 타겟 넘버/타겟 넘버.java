class Solution {
    public static boolean[]check;
	public static int ans=0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        check=new boolean[numbers.length];
		int sum=0;
		int n=numbers.length;
		for(int i:numbers) {
			sum+=i;
		}
		dfs(n,numbers,0,target,sum);
		return ans;
	}
	public static void dfs(int n,int[]numbers,int k,int target,int sum){
		if(k==n) {
			for(int i=0;i<n;i++) {
				if(check[i]) {
					sum=sum-(numbers[i]*2);
				}
			}
			if(sum==target) {
				ans++;
			}
			return;
		}
		
		check[k]=false;
		dfs(n,numbers,k+1,target,sum);
		check[k]=true;
		dfs(n,numbers,k+1,target,sum);
	}
    
}