class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        String a=""; String b="";
        for(int i:num_list){
            if(i%2==0){
                a+=i+"";
            }else{
                b+=i+"";
            }
        }
        answer=Integer.parseInt(a)+Integer.parseInt(b);
        return answer;
    }
}