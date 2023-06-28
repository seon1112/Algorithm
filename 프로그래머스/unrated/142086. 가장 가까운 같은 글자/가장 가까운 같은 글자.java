class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        answer = new int[s.length()];
		for(int i=s.length()-1;i>1;i--) {
			for(int j=i-1;j>=0;j--) {
				if(s.charAt(i)==s.charAt(j)) {
					answer[i]=i-j;
					break;
				}
			}
			if(answer[i]==0) {
				answer[i]=-1;
			}
		}
        if(answer.length>1){
            answer[1]=s.charAt(0)==s.charAt(1)?1:-1;
        }
	answer[0]=-1;
        return answer;
    }
}