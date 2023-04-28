import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer>que=new PriorityQueue<>();
		Arrays.sort(scoville);
		for(int i:scoville) {
			que.add(i);
		}
		while(que.peek()<K) {
            if(que.size()==1) {
				answer=-1;
				break;
			}
            int a=que.poll();
			int b=que.poll();
			que.add(a+b*2);
			answer++;
			
			if(answer>=scoville.length) {
				answer=-1;
				break;
			}
		}
        return answer;
    }
}