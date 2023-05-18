import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
		int count=0;
		HashMap<Integer, Integer>map=new HashMap<>();
			for(int i=0;i<tangerine.length;i++) {
				map.put(tangerine[i], map.getOrDefault(tangerine[i], 0)+1);
				int n=map.get(tangerine[i]);
			}
		Set<Integer>set =map.keySet();
		Iterator<Integer>iter=set.iterator();
		ArrayList<Integer>list=new ArrayList<>();
		
		while(iter.hasNext()) {
			list.add(map.get(iter.next()));
		}
		 
		list.sort(Comparator.reverseOrder());
		for(int s:list) {
			k=k-s;
			answer++;
			if(k<=0) {
				break;
			}
		}
        return answer;
    }
}
