import java.util.*;
	public class Main {
		public static void main(String[] args) {
			Scanner sc= new Scanner(System.in);
			int n=sc.nextInt();				//10
			int m=sc.nextInt();
			
			boolean flag=true;
			ArrayList<Integer>list=new ArrayList<>();
			for(int i=n;i<=m;i++) {
				if(i==2) {
					list.add(i);
				}
				if(i%2!=0&&i!=1) {
					list.add(i);
				}
			}
			for(int i:list) {
				flag=true;
				for(int j=2;j<=Math.sqrt(i);j++) {
					if(i%j==0) {
						flag=false;
						break;
					}
				}
				if(flag) {
					System.out.println(i);
				}
			}
		}
	
	}
