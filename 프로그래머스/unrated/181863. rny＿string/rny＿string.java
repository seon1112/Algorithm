class Solution {
    public String solution(String rny_string) {
        String answer = "";
        String str[]=rny_string.split("");
        for(int i=0;i<str.length;i++){
            if(str[i].equals("m")){
                str[i]="rn";
            }
            answer=answer+str[i];
        }
        return answer;
    }
}