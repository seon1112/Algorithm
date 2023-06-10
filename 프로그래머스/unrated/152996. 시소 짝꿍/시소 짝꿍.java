import java.util.HashMap;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
         double[] arr = { 2.0 / 4, 3.0 / 4, 2.0 / 3, 4.0 / 3, 3.0 / 2, 1.0, 2.0};
         HashMap<Double, Integer> map = new HashMap<>();

         for (double i : weights) {
             map.put(i, map.getOrDefault( i, 0) + 1);
         }

         for (double i : weights) {
             map.put(i, map.get(i) - 1);
             for (double d : arr) {
                 double n = i * d;
                 if (n >= 100.0 && n <= 100000.0) {
                     int cnt = map.getOrDefault(n, 0);
                     answer += cnt;
                 }
             }
             map.put(i, map.get(i) + 1);
         }
        return answer/2;
    }
}
