import java.util.ArrayList;
class Solution {
    public static int answer=0;
    public int solution(int m, int n, String[] board) {
         ArrayList<ArrayList<String>>list=new ArrayList<>();
		for(String s:board) {
			ArrayList<String> s_list=new ArrayList<>();
			for(int i=0;i<s.length();i++) {
				s_list.add(s.charAt(i)+"");
			}
			list.add(s_list);
		}
	
		search(list,m,n);
        return answer;
    }
    public static void search(ArrayList<ArrayList<String>>list,int m,int n) {
		ArrayList<Integer[]>set=new ArrayList<>();
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				String s=list.get(i).get(j);
				if(s.equals("0")) {
					continue;
				}
				if(i+1<m&&j+1<n) {
				 if(list.get(i+1).get(j).equals(s)&&list.get(i+1).get(j+1).equals(s)&&list.get(i).get(j+1).equals(s)) {
					 Integer[]str1= {i,j};
					 Integer[]str2= {i,j+1};
					 Integer[]str3= {i+1,j};
					 Integer[]str4= {i+1,j+1};
					 set.add(str1);
					 set.add(str2);
					 set.add(str3);
					 set.add(str4);
				 }
				}
			}
		}
		if(set.size()>0) {
			delete(list, m, n,set);
		}else {
			return;
		}
		
	}
	public static void delete(ArrayList<ArrayList<String>>list,int m,int n,ArrayList<Integer[]>set) {
		for(int a=0;a<set.size();a++) {
			int i=set.get(a)[0];
			int j=set.get(a)[1];
			if(!list.get(i).get(j).equals("0")) {
				list.get(i).remove(j);
				list.get(i).add(j, "0");
				answer++;
			}
			
		}
		move(list,m,n);
		
	}
	public static void move(ArrayList<ArrayList<String>>list,int m,int n) {
		for(int a=m-1;a>=0;a--) {
			for(int b=0;b<n;b++) {
				if(list.get(a).get(b).equals("0")) {
					for(int i=a;i>=0;i--) {
						if(!list.get(i).get(b).equals("0")) {
							list.get(a).remove(b);
							list.get(a).add(b, list.get(i).get(b));
							list.get(i).remove(b);
							list.get(i).add(b, "0");
                            break;
						}
					}
				}
				
				
			}
			
		}
		search(list,m,n);
		
	}
}