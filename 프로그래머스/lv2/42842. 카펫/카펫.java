class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
		
		int a=1, b=1;
		int c=a+b;
		c=(brown-4)/2;
		for(int i=1;i<c;i++) {
			a=i;
			b=c-i;
			if(a*b==yellow) {
				answer[0]=b+2;
				answer[1]=a+2;
				break;
			}
		}
        return answer;
    }
}