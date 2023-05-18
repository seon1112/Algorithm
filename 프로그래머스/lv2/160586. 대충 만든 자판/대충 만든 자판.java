import java.util.HashMap;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = {};
        answer = new int[targets.length];
			HashMap<String, Integer>map = new HashMap<>();
			for(int i=0;i<keymap.length;i++) {
				for(int j=0;j<keymap[i].length();j++) {
					String str =keymap[i].charAt(j)+"";
					if(map.getOrDefault(str, 0)==0) {
						map.put(str, j+1);
					}else {
						int n=Math.min(map.getOrDefault(str, 0),j+1);
						map.put(str,n);
					}
				
				}
			}
			System.out.println(map);
			
			for(int i=0;i<targets.length;i++) {
				for(int j=0;j<targets[i].length();j++) {
					String str=targets[i].charAt(j)+"";
					if(map.getOrDefault(str, 0)==0) {
						answer[i]=-1;
						break;
					}else {
						answer[i]+=map.get(str);
					}
				}
			}
        return answer;
    }
}
