import java.util.*;
class Solution {
    public static ArrayList<Long>al;
    public long solution(String expression) {
        long answer = 0;
        String [][]arr= {{"-","+","*"},{"-","*","+"},{"+","-","*"},{"+","*","-"},{"*","-","+"},{"*","+","-"}};
		ArrayList<String>list=new ArrayList<>();
		String s="";
		for(int i=0;i<expression.length();i++) {
			if(expression.charAt(i)=='*'||expression.charAt(i)=='-'||expression.charAt(i)=='+') {
				list.add(s);
				list.add(expression.charAt(i)+"");
				s="";
			}else {
				s+=(expression.charAt(i)+"");
			}
		}
		list.add(s);
		al=new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			ArrayList<String>list2=new ArrayList<>(list);
			sum(arr[i],list2);
		}
		System.out.println(al);
		al.sort(Comparator.naturalOrder());
		answer=al.get(al.size()-1);
        return answer;
    }
  public static void sum(String[]str,ArrayList<String>list2 ) {
		for(int i=0;i<3;i++) {
			String st=str[i];
			int index=list2.indexOf(st);
			while(index!=-1) {
				long a=0;
				if (st.equals("+")) {
				    a = Long.parseLong(list2.get(index-1)) + Long.parseLong(list2.get(index+1));
				} else if (st.equals("*")) {
				    a = Long.parseLong(list2.get(index-1)) * Long.parseLong(list2.get(index+1));
				} else if (st.equals("-")) {
				    a = Long.parseLong(list2.get(index-1)) - Long.parseLong(list2.get(index+1));
				} 
				list2.remove(index-1);
				list2.remove(index-1);
				list2.remove(index-1);
				list2.add(index-1, a+"");
				index=list2.indexOf(st);
			}
		
		}
		al.add(Math.abs(Long.parseLong(list2.get(0))));
		return;
	}
}