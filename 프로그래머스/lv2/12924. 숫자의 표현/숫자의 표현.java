class Solution {
    public int solution(int n) {
        int answer = 0;
        answer=1;
		for(int i=1;i<n;i++) {
			int count=i;
			for(int j=i+1;j<=n;j++) {
				count+=j;
				if(count==n) {
					answer++;
				}else if(count>n){
					break;
				}
			}
		}
        return answer;
    }
}