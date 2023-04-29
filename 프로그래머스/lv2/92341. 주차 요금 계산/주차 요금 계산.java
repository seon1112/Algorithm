import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        HashMap<String, Integer>map=new HashMap<>();
		HashMap<String, Integer>record=new HashMap<>();
		ArrayList<String>list=new ArrayList<>();
		
		for(int i=0;i<records.length;i++) {
			String str[]=records[i].split(" ");
			if(list.indexOf(str[1])==-1) {
				list.add(str[1]);
			}
				int hour=Integer.parseInt(str[0].substring(0,2))*60 + Integer.parseInt(str[0].substring(3));
				if(str[2].equals("IN")) {
					map.put(str[1], hour);
				}else {
					int total=hour-map.get(str[1]);
					record.put(str[1], record.getOrDefault(str[1], 0)+total);
					map.remove(str[1]);
				}
		}
		if(map.size()>0) {
			Set<String>set=map.keySet();
			Iterator<String>iter=set.iterator();
			
			while(iter.hasNext()) {
				String number=iter.next();
				int total=1439-map.get(number);
				record.put(number, record.getOrDefault(number, 0)+total);
			}
		}
		list.sort(Comparator.naturalOrder());
		
		answer=new int[list.size()];
		int i=0;
		
		for(String s:list) {
			int n=record.get(s);
			//기본시간,기본요금,단위시간,단위요금
			if(n<=fees[0]) {
				answer[i]=fees[1];
			}else {
				answer[i]=fees[1]+(int)Math.ceil((double)(n-fees[0])/fees[2])*fees[3];
			}
			i++;
			
		}

        return answer;
    }
}