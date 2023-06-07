class Solution {
    public int solution(int storey) {
        int answer = 0;
       StringBuffer sb=new StringBuffer(storey+"");
    	for(int i=sb.length()-1;i>0;i--) {
    		int n=sb.charAt(i)-'0';
    		if(n>=6) {
    			answer+=10-n;
    			int a=(int)Math.pow(10, sb.length()-i);
    			int b=Integer.parseInt(sb.toString())+a;
    			sb.replace(0, sb.length(), b+"");
    		}else if(n==5) {
    			int index=i-1;
    			if(sb.charAt(index)-'0'>=5) {
    				answer+=10-n;
        			int a=(int)Math.pow(10, sb.length()-i);
        			int b=Integer.parseInt(sb.toString())+a;
        			sb.replace(0, sb.length(), b+"");
    			}else {
    				answer+=n;
    			}
    		}else {
    			answer+=n;
    		}
    	}
    	int n=sb.charAt(0)-'0';
    	if(n>=6) {
    		answer+=10-n;
    		answer++;
    	}else {
    		answer+=n;
    	}
        return answer;
    }
}