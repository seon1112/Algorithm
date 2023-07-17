


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static int answer;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        String s=sc.nextLine();
        String []arr=s.split("");
        
        ArrayList<String>list=new ArrayList<String>();
        for(int i=0;i<n-1;i++) {
        	list.add(sc.nextLine());
        }
        
        for(int i=0;i<n-1;i++) {
        	String str=list.get(i);
        	HashMap<String, Integer>map=new HashMap<String, Integer>();
        	for(int j=0;j<arr.length;j++) {
            	map.put(arr[j], map.getOrDefault(arr[j], 0)+1);
            }
        	//System.out.println(map);
        	check(map,str);
        	
        }
        System.out.println(answer);
    }
    public static void check(HashMap<String, Integer>map,String str) {
    	int count=0;
    	for(int i=0;i<str.length();i++) {
    		String s=str.charAt(i)+"";
    		if(map.getOrDefault(s, 0)!=0) {
    			map.put(s, map.get(s)-1);
    		}else {
    			count++;
    		}
    	}
    	//System.out.println(map);
    	int count2=0;
    	for(int i:map.values()) {
    		if(i<0) {
    			i=i*-1;
    		}
    		count2+=i;
    	}
    	
    	//System.out.println("str:"+str+"     count2:"+count2+"   count:"+count);
    	if((count2==1 && count==0)||(count==1&&count2==0)||(count==0&&count2==0)||(count==1&&count2==1)) {
    		answer++;
    	}
    	return;
    	
    }
}
