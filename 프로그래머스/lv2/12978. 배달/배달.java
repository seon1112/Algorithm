import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int []check=new int[N+1];
		Arrays.fill(check,50000000 );
		check[1]=0;
        HashSet<String>set=new HashSet<>();
		LinkedHashMap<Integer,ArrayList<String>>map=new LinkedHashMap<>();
        for(int[]arr:road) {
			ArrayList<String>list=new ArrayList<>();
			int a=arr[0];
			int b=arr[1];
			int c=arr[2];
			
			if(map.containsKey(a)) {
				list=map.get(a);
				list.add(b+""+"+"+c+"");
				map.put(a, list);
			}else {
				list.add(b+""+"+"+c+"");
				map.put(a, list);
			}
			ArrayList<String>list2=new ArrayList<>();
			if(map.containsKey(b)) {
				list2=map.get(b);
				list2.add(a+""+"+"+c+"");
				map.put(b, list2);
			}else {
				list2.add(a+""+"+"+c+"");
				map.put(b, list2);
			}
					
		}   
		//{1=[21, 42], 2=[11, 33, 52], 3=[23, 51], 5=[22, 31, 42], 4=[12, 52]}
	
		Queue<String>que=new LinkedList<>();
		que.add(1+"");
		while(!que.isEmpty()) {
			String n=que.poll();
			ArrayList<String>list=map.get(Integer.parseInt(n));
			for(int i=0;i<list.size();i++) {  //2,4
				int index=list.get(i).indexOf("+");
				String str=list.get(i).substring(0,index);   //가는길
				String len=list.get(i).substring(index+1,list.get(i).length());	//거리
				if(Integer.parseInt(len)+check[Integer.parseInt(n)]<check[Integer.parseInt(str)]) {
					check[Integer.parseInt(str)]=Integer.parseInt(len)+check[Integer.parseInt(n)];
					if(check[Integer.parseInt(str)]<=K) {
						que.add(str);
                        set.add(str);
					}
				}
	
			
			}
		}
		
	
        answer=set.size()+1;
        return answer;
    }
}