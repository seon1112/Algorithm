import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer>que=new LinkedList<>();
		Stack<Integer>stack=new Stack<>();
		ArrayList<Integer>list=new ArrayList<>();  //1 2 3 4 5
		
		for(int i=1;i<=order.length;i++) {
			que.add(i);
		}
		int n=0;
		while(!que.isEmpty()) {
				int num=que.peek();			
				if(num==order[n]) {
					list.add(order[n]); n++; que.poll(); 
				}else if(!stack.isEmpty()&&order[n]==stack.peek()) {
					stack.pop(); n++; list.add(order[n]); 
				}else {
					stack.push(num);que.poll();		
				}
		}
		while(!stack.isEmpty()) {
			if(stack.pop()==order[n]) {
				list.add(order[n]); n++;
			}else {
				break;
			}
		}
		answer=list.size();
        return answer;
    }
}