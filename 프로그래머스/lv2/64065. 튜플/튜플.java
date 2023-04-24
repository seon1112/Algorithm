import java.util.Iterator;
import java.util.LinkedHashSet;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        	String str[]=s.split("\\},\\{");
		str[0]=str[0].substring(2);
		str[str.length-1]=str[str.length-1].substring(0,str[str.length-1].length()-2);
		
		LinkedHashSet<String>set=new LinkedHashSet<>();
		String [][]arr=new String[str.length][];
		
		for(int i=0;i<str.length;i++) {
			String ss[]=str[i].split(",");
			arr[ss.length-1]=ss;
		}
		for(int i=0;i<arr.length;i++) {
			for(String st : arr[i]) {
				set.add(st);	
			}
		}
		
		answer=new int[set.size()];
		Iterator<String>iter=set.iterator();
		int i=0;
		while(iter.hasNext()) {
			answer[i]=Integer.parseInt(iter.next());
			i++;
		}
        return answer;
    }
}