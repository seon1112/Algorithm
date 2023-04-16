class Solution {
    public int solution(int n) {
        int answer = 0;
        int a =Integer.bitCount(n);
		
		for(int i=n+1; ;i++){
		    int b=Integer.bitCount(i);
            if(a==b){
                return i;
            }
		}
        
    }
}