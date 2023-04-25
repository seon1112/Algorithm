import java.util.HashMap;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer>map=new HashMap<>();
		
		for(int i=0;i<=discount.length-10;i++) {
			boolean result =true;
			map.clear();
			for(int j=i;j<i+10;j++) {
				map.put(discount[j], map.getOrDefault(discount[j], 0)+1);
			}
			
			for(int k=0;k<want.length;k++) {
				if(map.getOrDefault(want[k],0)!=number[k]) {
					result=false;
					break;
				}
			}
			if(result==true) {
				answer++;
			}
		}
        return answer;
    }
}