import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        LinkedList<Integer>list=new LinkedList<>();
		Queue<Integer>que=new LinkedList<>();
		int n=(int)Math.ceil((100-progresses[0])/(double)speeds[0]);
		que.add(n);
		
		for(int i=1;i<speeds.length;i++) {
			 n=(int)Math.ceil((100-progresses[i])/(double)speeds[i]);
			int m=que.peek();
			if(m<n) {
				list.add(que.size());
				que.clear();
				que.add(n);
				
			}else {
				que.add(n);
			}
		}
		
		if(que.size()!=0) {
			list.add(que.size());
		}
	
		answer=new int[list.size()];
		for(int i=0;i<list.size();i++) {
			answer[i]=list.get(i);
		}
        return answer;
    }
}