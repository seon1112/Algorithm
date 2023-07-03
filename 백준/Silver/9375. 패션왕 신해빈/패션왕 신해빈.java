
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Main{

    private static final int String = 0;

	public static void main(String[] args) {
		ArrayList<Integer>result=new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
       int c=sc.nextInt();
       sc.nextLine();
       for(int j=0;j<c;j++) {
    	   int n=sc.nextInt();
           sc.nextLine();
           HashMap<String, ArrayList<String>>map=new HashMap<>();
           String[]arr=new String[2];
           for(int i=0;i<n;i++) {
        	   arr=sc.nextLine().split(" ");
        	   if(map.getOrDefault(arr[1], null)!=null) {
        		   ArrayList<String>list=map.get(arr[1]);
            	   list.add(arr[0]);
            	   map.put(arr[1], list);
        	   }else {
        		   ArrayList<String>list=new ArrayList<String>();
        		   list.add(arr[0]);
        		   map.put(arr[1],list);
        	   }
           }	
  
           int answer=1;
           Set<String>list=map.keySet();
           for(String s:list) {
        	   int a=map.get(s).size();
        	   answer*=(a+1);
           }
          result.add(answer-1);
       }
      for(int i:result) {
    	  System.out.println(i);
      }
    }
}
