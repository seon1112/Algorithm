import java.util.ArrayList;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        ArrayList<Integer>list=new ArrayList<>();
		while(n/k>k) {
			list.add(n%k);
			n=n/k;
		}
		list.add(n%k);
		list.add(n/k);
		
		String s="";
		for(int i=list.size()-1;i>=0;i--) {
			s+=list.get(i)+"";
		}
		String arr[]=s.split("0");
		boolean result=true;
        
		for(String str:arr) {
			if(str.equals("")||str.equals("1")) {
				continue;
			}
			long m=Long.parseLong(str);
		    int count=0;
			for(int i=1;i<=(int)(Math.sqrt(m));i++) {
				if(m%i==0) {
					count++;
				}
                if(count==2){
                    result=false;
                    break;
                }
			}
			answer+=result==true?1:0;
		}
        return answer;
    }
}