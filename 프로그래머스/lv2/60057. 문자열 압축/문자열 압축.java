
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int answer=10000;
    public int solution(String s) {
    if(s.length()==1){
        return answer=1;
    }
    int n=s.length()/2;   //8
    
    for(int i=1;i<=n;i++) {
    	int a=i;
    	check(s,a);
    }
        return answer;
    }
    public static void check(String s,int a) {
	StringBuffer sb=new StringBuffer();
	int count=1;
	Queue<String>que=new LinkedList<String>();
	int j=0;
	for(int i=0;i<s.length();i=j) {
		String str="";
		for(j=i;j<Math.min(i+a, s.length());j++) {
			str+=(s.charAt(j)+"");
		}
		if(que.isEmpty()) {
			que.offer(str);
		}else {
			if(str.equals(que.peek())) {
				count++;
			}else {     
				String pool=que.poll();
				if(count==1) {
					sb.append(pool);
				}else {
					sb.append(count+""+pool);
				}
				count=1;
				que.add(str);
			}
		}
	}
	if(!que.isEmpty()) {
		String pool=que.poll();
		if(count==1) {
			sb.append(pool);
		}else {
			sb.append(count+""+pool);
		}
	}
	answer=Math.min(answer, sb.length());
  }
}