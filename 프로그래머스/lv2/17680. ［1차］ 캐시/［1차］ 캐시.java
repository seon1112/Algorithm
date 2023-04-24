import java.util.ArrayList;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize==0){
            return cities.length*5;
        }
         ArrayList<String>list=new ArrayList<>();
		   String st=cities[0].toLowerCase();
		   list.add(st);
		   answer=5;
		   for(int i=1;i<cities.length;i++) {
			   String s = cities[i].toLowerCase();
			   if(list.indexOf(s)!=-1) {		//이미 배열안에 있을때\
				 list.remove(s);
				 list.add(s);
				 answer++;
			   }else {									// 배열에 없을때
				   if(list.size()==cacheSize) {
					   list.remove(0);
					   list.add(s);
				   }else {
					   list.add(s);
				   }
				   answer+=5;
			   }
			  
		   }
        return answer;
    }
}