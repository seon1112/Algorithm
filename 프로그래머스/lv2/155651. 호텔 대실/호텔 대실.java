import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
      public static ArrayList<String> arr;
    public int solution(String[][] book_time) {
        int answer = 0;
         arr = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();

        for (String[] time : book_time) {
            String s = time[0] + "+" + time[1];
            list.add(s);
        }

        list.sort((a, b) -> {
            LocalTime timeA = LocalTime.parse(a.substring(0, 5));
            LocalTime timeB = LocalTime.parse(b.substring(0, 5));
            return timeA.compareTo(timeB);
        });
        //[14:10+19:20, 14:20+15:20, 15:00+17:00, 16:40+18:20, 18:20+21:20]
        arr.add(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            check(list.get(i));
        }

        answer=arr.size();
        return answer;
    }
      public static void check(String time) {
        LocalTime endTime = LocalTime.parse(arr.get(0).substring(6, 11));
        LocalTime newStartTime = LocalTime.parse(time.substring(0, 5));
        if (!newStartTime.isAfter(endTime.plusMinutes(9))) {    //9분을 빼고 10분부터
        	arr.add(time);
        } else {
        	;arr.set(0, time);
        }
        
        
        Collections.sort(arr, (a, b) -> {
            LocalTime timeA = LocalTime.parse(a.substring(6, 11));
            LocalTime timeB = LocalTime.parse(b.substring(6, 11));
            return timeA.compareTo(timeB);
        });
    }
}
