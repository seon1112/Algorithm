import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int []arr=new int[priorities.length];
		LinkedHashMap<String, Integer>map=new LinkedHashMap<>();
		Queue<String>que=new LinkedList<>();
		
		String m = (char)(location+65)+"";			//E
		
		for(int i=0;i<priorities.length;i++) {
			String s=(char)(i+65)+"";
			map.put(s, priorities[i]);
			que.add(s);
			arr[i]=priorities[i];
		}
		Arrays.sort(arr);		//1,2,2,3,4
		
		for(int i=arr.length-1;i>=0;i--) {
			int max=arr[i];
			for(int j=0;j<arr.length;j++) {
				String n=que.peek();
				if(map.get(n)!=max) {
					que.poll();
					que.add(n);
				}else {
					que.poll();
					answer++;
                    if(n.equals(m)){
                        return answer;
                    }
					break;
				}
			
			}
		}
        return answer;
    }
}