import java.util.HashMap;
import java.util.HashSet;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer>map=new HashMap<>();
    	HashSet<Integer>set=new HashSet<>();
    	for(int i:topping) {
    		map.put(i, map.getOrDefault(i, 0)+1);
    	}
    	int b= map.size();				//숫자종류  처음엔 0:k 형
    	for(int i=0;i<topping.length;i++) {
    		if(map.get(topping[i])==1) {
    			map.put(topping[i], map.get(topping[i])-1);
    			b=b-1;
    			set.add(topping[i]);
    		}else if(map.get(topping[i])>1){
    			map.put(topping[i], map.get(topping[i])-1);
    			set.add(topping[i]);
    		}
    		if(set.size()==b) {
    			answer++;
    		}
    	}
        return answer;
    }
}