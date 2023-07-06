


import java.util.Scanner;

public class Main {
	public static int n,R,C,result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         n=sc.nextInt();
         R=sc.nextInt(); //r행
         C=sc.nextInt(); //c열
        int size=(int)Math.pow(2, n);
      //  System.out.println("size : "+size);
        check(0,0,size);
        System.out.println(result);
    }
    public static void check(int r,int c,int size) {
    //	System.out.println("result:"+result);
    	if(size==1) {
    		return;
    	}
    	int ns=size/2; //새로운 사이즈
    	//System.out.println("ns:"+ns);
    	//System.out.println("r:"+r+",c:"+c);
    	//1사분면
    	if(R<(r+ns)&&C<(c+ns)) {
    		//System.out.println("1");
    		check(r,c,ns);
    	}
    	//2사분면
    	if(R<(r+ns)&&C>=(c+ns)) {
    	//	System.out.println("2");
    		result+=(size*size)/4;
    		check(r,c+ns,ns);
    	}
    	//3사분면
    	if(R>=(r+ns)&&C<(c+ns)) {
    		//System.out.println("3");
    		result+=(size*size)/2;
    		check(r+ns,c,ns);
    	}
    	//4사분면
    	if(R>=(r+ns)&&C>=(c+ns)) {
    	//	System.out.println("4");
    		result+=(size*size)/4*3;
    		check(r+ns,c+ns,ns);
    	}
    	
    }
}
