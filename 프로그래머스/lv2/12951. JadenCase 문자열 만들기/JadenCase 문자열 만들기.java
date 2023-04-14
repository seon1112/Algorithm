class Solution {
    public String solution(String s) {
        String answer = "";
        s=s.toLowerCase();
		StringBuilder sb=new StringBuilder(s);
		if(sb.charAt(0)>='0'&&sb.charAt(0)<='9') {	
		}else {
			String m=(char)(sb.charAt(0)-32)+"";
			sb.replace(0, 1, m);
		}
		for(int i=0;i<sb.length()-1;i++) {
			if(sb.charAt(i)==' ') {
				for(int j=i+1;j<sb.length();j++) {
					if(sb.charAt(j)!=' ') {
						if(sb.charAt(j)>='0'&&sb.charAt(j)<='9') {	
							break;
						}else {
						char ch=(char)(sb.charAt(j)-32);
						sb.replace(j, j+1, ch+"");
						i=j;
						break;
						}
					}
				}
			}
		}
		answer=sb.toString();
        return answer;
    }
}