import java.util.ArrayList;
class Solution {
    public int solution(String s) {
        int answer = -1;
        answer=0;
		String []arr= {"()","{}","[]"};
		String str[]=s.split("");
		ArrayList<String>list=new ArrayList<String>();
		for(String m : str) {
			list.add(m);
		}
		
		for(int i=0;i<list.size();i++) {
			list.add(0, list.get(list.size()-1));
			list.remove(list.size()-1);
			String st="";
			StringBuilder sb=new StringBuilder(st);
			for(String k:list) {
				sb.append(k);
			}
			
			
			int a=0;
			int b=0;
			int c=0;
			
			while(a!=-1||b!=-1||c!=-1) {
				 a=sb.indexOf(arr[0]);
				 b=sb.indexOf(arr[1]);
				 c=sb.indexOf(arr[2]);
				if(a>-1) {
					sb.delete(sb.indexOf(arr[0]),sb.indexOf(arr[0])+2);
				}else if(b>-1) {
					sb.delete(sb.indexOf(arr[1]),sb.indexOf(arr[1])+2);
				}else if(c>-1) {
					sb.delete(sb.indexOf(arr[2]),sb.indexOf(arr[2])+2);
				}
				
			}
			
			if(sb.length()==0) {
				answer++;
			}
		}
        return answer;
    }
}