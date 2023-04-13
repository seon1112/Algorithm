class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {}; answer =new int[2];
		int a=park.length-1; //세로
        int b=park[0].length()-1; //가로
		String []spl=new String[2];
		for(int i=0;i<park.length;i++ ) {
				for(int j=0;j<park[i].length();j++) {
					if(park[i].charAt(j)=='S') {
						answer[0]=i;    //위아래
						answer[1]=j;    //옆
					}
				}
		}
		for(int k=0;k<routes.length;k++) {
			spl=routes[k].split(" ");
			int n=Integer.parseInt(spl[1]); int r=0;
			switch(spl[0]) {
			case "N" ://위
				 r=0;
				if(answer[0]-n>=0) {
					int m=1;
					while(m<=n) {
						if(park[answer[0]-m].charAt(answer[1])=='X')                        {
							r =1;break;
						}m++;}
					if(r==0) {
						answer[0]=answer[0]-n;break;
                    }else{break;}
				}else {break;
				}

			case "S" :	//아래
				 r=0;
				if(answer[0]+n<=a) {
					int m=1;
					while(m<=n) {
						if(park[answer[0]+m].charAt(answer[1])=='X') {
						 r =1;
						 break;
						}
						m++;
					}
					if(r==0) {
						answer[0]=answer[0]+n;break;
					}else{break;}	
				}else {
					break;
				}	
			case "W" ://왼
				 r=0;
				if(answer[1]-n>=0) {
					int m=1;
					while(m<=n) {
						if(park[answer[0]].charAt(answer[1]-m)=='X') {
							r =1;
							break;
						};
						m++;
					}
					if(r==0) {
						answer[1]=answer[1]-n;
						break;
					}else{break;}
				}else {
					break;
				}
			case "E" :	
				 r=0;//오
				if(answer[1]+n<=b) {
					int m=1;
					while(m<=n) {
						if(park[answer[0]].charAt(answer[1]+m)=='X') {
							r =1;
							break;
						}
						m++;
					}
					if(r==0) {
						answer[1]=answer[1]+n;
						break;
					}else{break;}
					
				}else {
				
					break;
				}
			}
		}
		
        return answer;
    }
}