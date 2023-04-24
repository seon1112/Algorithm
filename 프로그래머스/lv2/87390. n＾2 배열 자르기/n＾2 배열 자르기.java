
import java.util.ArrayList;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = {};
        answer=new int[(int)(right-left+1)];
		ArrayList<Integer>list=new ArrayList<Integer>();
		long a1 = left/n; 	long a2 = left%n;	//0,2
		long b1 = right/n;	long b2 = right%n;	//1,2
		
		
		
		if(a1==b1) {
			for(long j=a2;j<=b2;j++) {	//2,3
				if(a1>=j) {
					list.add((int)a1+1);
				}else {
					list.add((int)j+1);
				}
			}
		}else {
			for(long i=a1; i<=b1;i++) { //0,1
				if(i==a1) {
					for(long j=a2;j<n;j++) {	//2,3
						if(i>=j) {
							list.add((int)i+1);
						}else {
							list.add((int)j+1);
						}
					}
				}else if(i!=b1) {
					for(long j=0;j<n;j++) {
						if(i>=j) {
							list.add((int)i+1);
						}else {
							list.add((int)j+1);
						}
					}
				}else if(i==b1) {
					for(long j=0;j<=b2;j++) {
						if(i>=j) {
							list.add((int)i+1);
						}else {
							list.add((int)j+1);
						}
					}
				}
				
			}
		}
		
		for(int i=0;i<list.size();i++) {
			answer[i]=list.get(i);
		}
        return answer;
    }
}