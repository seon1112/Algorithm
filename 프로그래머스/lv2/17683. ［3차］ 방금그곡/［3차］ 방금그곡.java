import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        m=m.replaceAll("C#", "c").replaceAll("A#", "a").replaceAll("G#", "g").replaceAll("D#", "d").replaceAll("F#", "f");
		LinkedHashMap<String, ArrayList<String>>map=new LinkedHashMap<>();
		StringBuffer sb=new StringBuffer();
		
		for(int i=0;i<musicinfos.length;i++) {
			String s=musicinfos[i];
			String []arr=s.split(",");
			
			String a_hour_start=arr[0].substring(0,1).indexOf('0')!=-1?arr[0].substring(1,2):arr[0].substring(0,2); 
			String a_min_start=arr[0].substring(3,4).indexOf('0')!=-1?arr[0].substring(4):arr[0].substring(3); 
			String a_hour_end=arr[1].substring(0,1).indexOf('0')!=-1?arr[1].substring(1,2):arr[1].substring(0,2); 
			String a_min_end=arr[1].substring(3,4).indexOf('0')!=-1?arr[1].substring(4):arr[1].substring(3); 
			int a_hour=Integer.parseInt(a_hour_end)*60+Integer.parseInt(a_min_end) -(Integer.parseInt(a_hour_start)*60+Integer.parseInt(a_min_start));
		
			String str=arr[3]; //CDEFGAB 7 14
			str=str.replaceAll("C#", "c").replaceAll("A#", "a").replaceAll("G#", "g").replaceAll("D#", "d").replaceAll("F#", "f");
			int n=a_hour/str.length();
			while(n>0) {
				sb.append(str);
				n--;
			}
			sb.append(str.substring(0,a_hour%str.length()));
			ArrayList<String>list=new ArrayList<>();
			list.add(sb.toString());
            list.add(a_hour+"");
			map.put(arr[2], list);
			sb.setLength(0);
		}
	
		for(String s:map.keySet()) {
			if(map.get(s).get(0).contains(m)) {
				if(answer.equals("")) {
					answer=s;
				}else {
					if (Integer.parseInt(map.get(s).get(1))>Integer.parseInt(map.get(answer).get(1)))
						answer = s;
				}
			}
		}
		if(answer.equals("")) {
			answer="(None)";
		}
        return answer;
    }
}