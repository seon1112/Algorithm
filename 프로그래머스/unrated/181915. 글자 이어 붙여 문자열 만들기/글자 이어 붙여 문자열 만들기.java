import java.util.*;
class Solution {
    public String solution(String my_string, int[] index_list) {
        String answer = "";
        String []str=my_string.split("");
        HashMap<Integer,String>map=new HashMap<>();
        for(int i=0;i<str.length;i++){
            map.put(i,str[i]);
        }
        for(int i:index_list){
            answer+=map.get(i);
        }
        return answer;
    }
}