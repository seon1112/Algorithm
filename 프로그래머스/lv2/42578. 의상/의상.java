import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
         answer=1;
		 HashMap<String,Integer> map=new HashMap<>();
		 for(int i=0;i<clothes.length;i++) {
			 map.put(clothes[i][1],map.getOrDefault(clothes[i][1], 0)+1 );
		 }
		 Set<String>set=map.keySet();
		 Iterator<String>iter=set.iterator();
		 while(iter.hasNext()) {
			 String s=iter.next();
			answer*=map.get(s)+1;
		 }
		 answer=answer-1;
        return answer;
    }
}