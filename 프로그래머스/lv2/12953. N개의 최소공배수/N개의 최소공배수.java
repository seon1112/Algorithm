import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        ArrayList<Integer> array=new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<2) {
				continue;
			}
			ArrayList<Integer>list=sub(arr[i]);
			
			if(array.size()==0) {
				for(int b=0;b<list.size();b++) {
					array.add(list.get(b));
				}
			}else {
				for(int j=0;j<array.size();j++) {
					int a=array.get(j);
					if(list.contains(a)) {
						list.remove(list.indexOf(a));
					}
				}
				
				if(list.size()==0) {
					continue;
				}
				for(int k=0;k<list.size();k++) {
					array.add(list.get(k));
				}
			}
			
		}
		for(int i=0;i<array.size();i++) {
			answer*=array.get(i);
		}
        return answer;
    }
    public static ArrayList<Integer> sub(int n) {
		ArrayList<Integer>list=new ArrayList<>();
		for(int i=2;i<=n;i++) {
			if(n%i==0) {
				while(n%i==0) {
					list.add(i);
					n=n/i;
				}
			}
		}
		return list;
	}
}