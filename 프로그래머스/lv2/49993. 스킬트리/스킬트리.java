import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = -1;
        answer=0;
		
		HashMap<String, Integer>map=new HashMap<>();
		int i=1;
		for(String s:skill.split("")) {
			map.put(s, i);
			i++;
		}
		System.out.println(map);
		for(int j=0;j<skill_trees.length;j++) {
			boolean result=true;
			int count=1;
			for(String m:skill_trees[j].split("")) {
				if(map.getOrDefault(m, 0)!=0) {
					if(map.get(m)==count) {
						count++;
						if(count==map.size()) {
							break;
						}
					}else {
						result=false;
						break;
					}
				}
			}
			if(result) {
				answer++;
			}
		}
        return answer;
    }
}