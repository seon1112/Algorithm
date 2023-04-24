import java.util.ArrayList;
import java.util.HashSet;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        ArrayList<Integer>list = new ArrayList<>();
		for(int i=0;i<2;i++) {
			for(int j=0;j<elements.length;j++) {
				list.add(elements[j]);
			}
		}
		
		HashSet<Integer>set= new HashSet<>();
		int sum=0;
		for(int i=0;i<elements.length;i++) {
			for(int j=0;j<elements.length;j++) {
				for(int k=j;k<=j+i;k++) {
					sum+=list.get(k);
				}
				set.add(sum);
				sum=0;
			}
		}
        answer=set.size();
        return answer;
    }
}