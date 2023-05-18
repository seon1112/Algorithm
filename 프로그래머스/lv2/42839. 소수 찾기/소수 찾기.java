import java.util.*;
class Solution {
    public static int answer;
    public int solution(String numbers) {
        int n=0;
		HashSet<Integer> set=new HashSet<Integer>();
		String []arr=numbers.split("");
		boolean []check=new boolean[arr.length];
		perm(arr,check,set,n);
		answer=set.size();
        return answer;
    }
    public static void perm(String []arr, boolean[]check,HashSet<Integer> set,int n) {
		if(n==arr.length) {
			ArrayList<String>list=new ArrayList<>();
			for(int i=0;i<arr.length;i++) {
				if(check[i]) {
					list.add(arr[i]);
				}
			}
			perm2(list,set,0);
			return;
		}
		
		check[n]=false;
		perm(arr,check,set,n+1);
		check[n]=true;
		perm(arr,check,set,n+1);
	}
	public static void perm2(ArrayList<String>list,HashSet<Integer> set,int r) {
		if(list.size()==r) {			//마지막 위치에 도달
			String s="";
			for(int i=0;i<list.size();i++) {
				s+=list.get(i);
			}
			if(!s.equals("")) {
				int a=Integer.parseInt(s);
				if(a==1) {
					a=0;
				}else {
					for(int i=2;i<=a/2;i++) {
						if(a%i==0) {
							a=0;
							break;
						}
					}
				}
				
				if(a!=0) {
					set.add(a);
				}
			}
			return;
		}
		
		for(int i=r;i<list.size();i++) {
			swap(list,i,r);
			perm2(list,set,r+1);
			swap(list,i,r);
		}
		
		
	}
	private static void swap(ArrayList<String>list,int i, int j) {
		String tempi=list.get(i);
		String tempj=list.get(j);
		list.remove(i);
		list.add(i, tempj);
		list.remove(j);
		list.add(j,tempi);
		
	}

}