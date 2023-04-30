
import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        HashMap<String, String>map=new HashMap<>();
		
		for(String s:record) {
			String str[]=s.split(" ");
			if(str.length==3) {
				map.put(str[1], str[2]);
			}
		}
		ArrayList<String>list=new ArrayList<>();
		
		for(String s:record) {
			if(s.indexOf("Enter")!=-1) {
				s=s.substring(6, s.lastIndexOf(" "));
				list.add(map.get(s)+"님이 들어왔습니다.");
				
			}else if(s.indexOf("Leave")!=-1) {
				s=s.substring(6);
				list.add(map.get(s)+"님이 나갔습니다.");
			}
		}
		answer=new String[list.size()];
		int i=0;
		for(String s:list) {
			answer[i]=s;
			i++;
		}
        return answer;
    }
}