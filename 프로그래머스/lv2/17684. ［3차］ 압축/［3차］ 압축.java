import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        ArrayList<Integer>list=new ArrayList<>(); 			//answer를 담을 list
		
		HashMap<String, Integer>map=new HashMap<>();
		for(int i=0;i<26;i++) {
			map.put((char)(65+i)+"", i+1);
		}
		boolean flag=true;
		int j=0;
		for(int i=0;i<msg.length();i=j) {
			String s=msg.charAt(i)+"";
			if(i+1<msg.length()) {
				for(j=i+1;j<msg.length();j++) {
					if(map.getOrDefault(s+msg.charAt(j)+"", 0)==0) {
						map.put(s+msg.charAt(j)+"", map.size()+1);
						list.add(map.get(s));
						break;
					}else {
						s+=msg.charAt(j);
					}
					
					if(j+1==msg.length()) {
						list.add(map.get(s));
						j=j+2;
						break;
					}
				}
			}else {
				list.add(map.get(s));
				break;
			}
				
		}
		answer=new int[list.size()];
		for(int i=0;i<list.size();i++) {
			answer[i]=list.get(i);
		}
        return answer;
    }
}