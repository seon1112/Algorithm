class Solution {
    public String solution(String s) {
        String answer = "";
        String str[]=s.split(" ");
        int max=-10000000; 
        int min=10000000;
        for(int i=0;i<str.length;i++){
        	int n=Integer.parseInt(str[i]);
            max=Math.max(max,n);
            min=Math.min(min,n);
        }
        
       answer=min+""+" "+max+"";
        return answer;
    }
}