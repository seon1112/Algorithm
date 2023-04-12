class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        answer = new int[4];
		int max_x=0;		
		int max_y=0;		
		int min_x=0;		
		int min_y=0;		
		int a=0;
		for(int i=0;i<wallpaper.length;i++) {
			for(int j=0;j<wallpaper[0].length();j++) {
				if(wallpaper[i].charAt(j)=='#') {
					if(a==0) {
						max_x=j;
						max_y=i;
						min_x=j;
						min_y=i;
						a++;
					}else {
						if(j>max_x) {
							max_x=j;
						}else if(j<min_x) {
							min_x=j;
						}
						if(i>max_y) {
							max_y=i;
						}else if(i<min_y) {
							min_y=i;
						}
					}
				}
			}
		}
		answer[0]=min_y;
		answer[1]=min_x;
		answer[2]=max_y+1;
		answer[3]=max_x+1;
		
        return answer;
    }
}