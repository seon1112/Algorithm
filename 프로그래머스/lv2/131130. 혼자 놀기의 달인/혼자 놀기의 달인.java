import java.util.ArrayList;
class Solution {
    public static ArrayList<Integer>list1;
	public static ArrayList<Integer>list2;
    public int solution(int[] cards) {
        int answer = 0;
        int tot=0;
    	list1=new ArrayList<>();
    	list2=new ArrayList<>();
    	for(int i=0;i<cards.length;i++) {
    		tot=box(cards,0,i,list1);
        	for(int j=0;j<cards.length;j++) {
        		int sum=0;
        		if(!list1.contains(j)) {
        			sum=box(cards,0,j,list2);
        			answer=Math.max(answer, sum*tot);
            		list2.clear();
        		}
        	}
        	list1.clear();
    	}
        return answer;
    }
      public static int box(int[] cards,int tot,int n,ArrayList<Integer>list) {
    	boolean flag=true;
    	while(true) {
    		int num=cards[n];
    		tot++;
    		list.add(n);
    		if(list.contains(num-1)||list1.contains(num-1)) {
    			break;
    		}
    		n=num-1;
    	}
    	return tot;
    }
}