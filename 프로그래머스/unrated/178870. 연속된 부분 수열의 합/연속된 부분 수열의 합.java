class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        answer=new int[2];
		
		int start=0;
		int end=0;
		int sum=sequence[0];
		int size=1000001;
		while (true) {
			if (sum < k) {
				end++;
				if (end >= sequence.length) {
					break;
				}
				sum += sequence[end];
				
			} else if (sum > k) {
				sum -= sequence[start];
				start++;
			} else {
				if (size > end - start) {
					size = end - start;
					answer[0] = start;
					answer[1] = end ;
				}
				sum -= sequence[start];
				start++;
			}
			
			
			
		}
		
        return answer;
    }
}