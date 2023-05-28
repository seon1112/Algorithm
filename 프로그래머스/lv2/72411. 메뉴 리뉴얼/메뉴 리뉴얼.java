import java.util.*;
class Solution {
    public static ArrayList<String> result;
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        result=new ArrayList<>();
		
        HashSet<String>set=new HashSet<>();
        for(int i=0;i<orders.length;i++) {
            for(int j=0;j<orders[i].length();j++) {
                set.add(orders[i].charAt(j)+"");	//[A, B, C, D, E, F, G, H]
            }
        } 
        String []arr=set.toArray(new String[0]);		//set을 arr로 변환

        for(int i=0;i<course.length;i++) {
            int n=course[i];				//메뉴의 개수 
            ArrayList<String> com=new ArrayList<>();
            boolean[]check=new boolean[arr.length];
            combination(arr,0,n,com,check);			//가능한 조합 확인 //[A,B]
            count(orders,com);				//[AC, CDE, ACDE, BCFG]
        }


        result.sort(Comparator.naturalOrder());
        	answer=new String[result.size()];
		for(int i=0;i<result.size();i++) {
			answer[i]=result.get(i);
		}
        return answer;

        }
        //가능한 조합 만들기
        public static void combination(String []arr, int start, int n,ArrayList<String> com,boolean[]check) {
            if(n==0) {
                String temp="";
                for(int i=0;i<arr.length;i++) {
                    if(check[i]) {
                        temp+=arr[i];
                    }
                }
                com.add(temp);
                return;
            }

            for(int i=start;i<arr.length;i++) {
                check[i]=true;
                combination(arr,i+1,n-1,com,check);
                check[i]=false;
            }
        }
        //orders에서 배열 개수 카운팅
        public static void count(String[] orders,ArrayList<String> com) {
            HashMap<String, Integer>map=new HashMap<>();
            int max=-2;
            for(int i=0;i<com.size();i++) {
                String s=com.get(i);
                for(int j=0;j<orders.length;j++) {			//order 하나씩 꺼내서
                    boolean flag=true;
                    for(int k=0;k<s.length();k++) {				//비교
                        if(orders[j].indexOf(s.charAt(k)+"")==-1) {
                            flag=false;
                            break;
                        }
                    }
                    if(flag) {
                        map.put(s, map.getOrDefault(s,0)+1);
                        max=Math.max(max, map.get(s));
                    }
                }
            }
            if(max<2) {
                return;
            }
            Set<String>set=map.keySet();
            Iterator<String>iter=set.iterator();
            while(iter.hasNext()) {
                String str=iter.next();
                if(map.get(str)==max) {
                    result.add(str);
                }
            }



        }
}