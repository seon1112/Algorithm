import java.util.*;
class Solution {
    public static long sum1;
	public static long sum2;
	public static long target;
	public static int answer;
    public int solution(int[] queue1, int[] queue2) {
        Queue<Long>que1=new LinkedList<>();
		Queue<Long>que2=new LinkedList<>();

		for(int i:queue1) {
			que1.add((long)i);
			target+=(long)i;
			sum1+=(long)i;
		}
		for(int i:queue2) {
			que2.add((long)i);
			target+=(long)i;
			sum2+=(long)i;
		}
        if(sum1==sum2){
            return 0;
        }
		target=target/2;
		cal(que1,que2);
		
        if(sum1!=sum2) {
			answer=-1;
		}
        return answer;
    }
   public static void cal(Queue<Long>que1,Queue<Long>que2) {
		int n=0; int s=que1.size();
		while(sum1!=sum2&&!que1.isEmpty()&&!que2.isEmpty()&&n<=s*10) {
			if(sum1>sum2) {
				long a=que1.poll();
				que2.add(a);
				sum1-=a; sum2+=a;
				answer++;
		}else if(sum1<sum2) {
			long a=que2.poll();
			que1.add(a);
			sum2-=a; sum1+=a;
			answer++;
		}
				n++;
		}
		
	}
}