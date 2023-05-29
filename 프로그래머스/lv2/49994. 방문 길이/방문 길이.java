import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        HashMap<String, int[]>map=new HashMap<>();
		map.put("U", new int[]{0,1});
		map.put("D", new int[]{0,-1});
		map.put("R", new int[]{1,0});
		map.put("L", new int[]{-1,0});
		
		HashSet<String>set=new HashSet<>();
		int []start= {0,0};
		
		for(int i=0;i<dirs.length();i++) {
			String s=dirs.charAt(i)+"";
			int []arr=map.get(s);
			String str="";
			
			int a=start[0];
			int b=start[1];
			int c=start[0]+arr[0];
			int d=start[1]+arr[1];
			
			if(c<-5||d<-5||c>5||d>5) {
				continue;
			}
			
			str=a+""+b+""+c+""+d+"";
			set.add(str);
			str=c+""+d+""+a+""+b+"";
			set.add(str);		
			start[0]=c;
			start[1]=d;
			
		}
	answer=set.size()/2;
        return answer;
    }
}