import java.util.ArrayList;
class Solution {
    public int solution(int n) {
        int answer = 0;
		ArrayList<Integer>list =new ArrayList<>();
		list.add(0);
		list.add(1);
		int c=1234567;
		for(int i=2;i<=n;i++) {
			list.add(list.get(i-2)%c+list.get(i-1)%c);
		}
        return list.get(n)%c;
    }
}