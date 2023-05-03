class Solution {
    public static int answer = 0;
    public static int tryCount=0;
    public int solution(String word) {
        String str[]= {"A", "E", "I", "O", "U"};
        String s="";
        perm(str, 5, s,word); 
        return answer;
    }
     public static void perm(String []str,int r,String s,String word) {
    	if(s.equals(word)) {
            answer = tryCount;
            return; 
        }
        if(s.length() == r) {
            return;
        }
        for(int i=0; i<str.length; i++) {
            s += str[i];
            tryCount++;
            perm(str, r, s,word); 
            s = s.substring(0, s.length() - 1);
        }
}
}