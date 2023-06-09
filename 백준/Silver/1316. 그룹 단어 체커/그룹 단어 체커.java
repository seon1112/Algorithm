import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
    	int answer=0;
       Scanner sc= new Scanner(System.in);
       int n=sc.nextInt();
       sc.nextLine();
       String []arr=new String[n];
       for(int i=0;i<n;i++) {
    	   arr[i]=sc.nextLine();
       }
       
      //시작하기
      
      for(int i=0;i<arr.length;i++) {
    	  Stack<String>stack=new Stack<>();
          HashSet<String>set=new HashSet<>();
    	  boolean flag=check(stack,set,arr[i]);
    	  if(flag) {
    		  answer++;
    	  }
      }
      System.out.println(answer);
    }
    public static boolean check(  Stack<String>stack,HashSet<String>set,String str) {
    	boolean flag=true;
    	for(int i=0;i<str.length();i++) {
    		String s=str.charAt(i)+"";
    	  	  if(stack.isEmpty()) {
    	  		  stack.add(s);
    	  		  set.add(s);
    	  	  }else {
    	  		  if(stack.peek().equals(s)) {
    	  			stack.add(s);
    	  		  }else{
    	  			  if(set.contains(s)) {
    	  				  flag=false;
    	  				  break; 
    	  			  }else {
    	  				stack.add(s);
    	  				set.add(s);
    	  			  }
    	  			  
    	  		  }
    	  	  }
    	}
    	
    	return flag;
    	
    }
}
