import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
         
        int len=number.length()-k;		//6
        Stack<Character>stack=new Stack<>();
        int start=0;
        for(int i=0;i<len;i++) {
        	int end=i+number.length()-len;			
        	stack.push(number.charAt(start));
        	for(int j=start+1;j<=end;j++) {
                if(stack.peek()=='9'){
                    break;
                }
        		else if(stack.peek()<number.charAt(j)) {
        			stack.pop();
        			stack.push(number.charAt(j));
        			start=j;
        		}
        	}
        	start++;
        }
 
       while(!stack.isEmpty()) {
    	   String s=stack.pop()+"";
    	   answer=s+answer;
       }
        return answer;
    }
}