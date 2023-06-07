import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public static int answer;
    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
    	Arrays.sort(arrayB);
 
    	for(int i=arrayA[0];i>1;i--) {
    		int n=i;
    		checkA(arrayA,arrayB,n);
    		
    	}
    		for(int i=arrayB[0];i>1;i--) {
        		int n=i;
        		checkA(arrayB,arrayA,n);
        		
        	}
    	
        return answer;
    }
    
    public static void checkA(int[] array1,int[] array2,int n) {
	  for(int i=0;i<array1.length;i++) {
		  if(array1[i]%n!=0) {
			  return;
		  }
	  }
	  checkB(n,array2);
  }
  public static void checkB(int n,int[] array2) {
	  for(int i=0;i<array2.length;i++) {
		  if(array2[i]%n==0) {
			  return;
		  }
	  }
	  answer=Math.max(answer,n);
  }
}