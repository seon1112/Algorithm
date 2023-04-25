import java.util.ArrayList;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        String []arr1=str1.toLowerCase().split("");
		String []arr2=str2.toLowerCase().split("");
		
		ArrayList<String>list=new ArrayList<>();	//str1담아
		
		for(int i=0;i<arr1.length-1;i++) {
			String s=arr1[i]+arr1[i+1];
			if(s.matches("^[a-z]*$")) {
				list.add(s);
			}
		}
		int a=list.size();		//원래 str1의 길이
		int b=0;				//str1이 갖고 있지 않은 str2
		
		for(int i=0;i<arr2.length-1;i++) {
			String s=arr2[i]+arr2[i+1];
			if(s.matches("^[a-z]*$")) {
				if(list.contains(s)) {
					list.remove(s);
				}else {
					b++;
				}
			}
		}
		
		int c=list.size();			//str1의 차집합
		int guo=a-c;
		int sum=b+a;
		if(a==0&&b==0){
            return answer=65536;
        }
		answer=(int)Math.floor(((double)guo/sum)*65536);
        return answer;
    }
}