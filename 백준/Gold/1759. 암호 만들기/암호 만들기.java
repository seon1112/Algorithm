

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static String []str= {"a","e","i","o","u"};
    public static String []pwd;
    public static boolean[]check;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l=sc.nextInt();
        int c=sc.nextInt();
        sc.nextLine();
        pwd=new String[c];
    	pwd=sc.nextLine().split(" ");
        Arrays.sort(pwd);
        check=new boolean[c];
        perm(c,l,0,0);
        
	}
	public static void perm(int c,int l,int tot,int n) {
	//a c i s t w
		if(tot==l) {
			StringBuffer sb=new StringBuffer();
			for(int i=0;i<c;i++) {
				if(check[i]) {
					sb.append(pwd[i]);
				}
			}
			int count=0;
			for(int i=0;i<5;i++) {
				if(sb.indexOf(str[i])!=-1) {
					count++;
				}
			}
			if(count>0&&count<=(l-2)) {
				System.out.println(sb);
			}
			return;
		}
		
		for(int i=n;i<c;i++) {
			if(!check[i]) {
				check[i]=true;
				perm(c,l,tot+1,i+1);
				check[i]=false;
			}
		}
	}
}
