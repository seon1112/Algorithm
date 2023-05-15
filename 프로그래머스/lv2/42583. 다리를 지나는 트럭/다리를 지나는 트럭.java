import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
         Queue<Integer> que = new LinkedList<>();
        int sum = 0;
         for (int i = 0; i < truck_weights.length; i++) {
            int truckWeight = truck_weights[i];
            
            while (true) {
                if (que.isEmpty()) {
                    que.add(truckWeight);
                    sum += truckWeight;
                    answer++;
                    break;
                } else if (que.size() == bridge_length) {
                    sum -= que.poll();
                } else {
                    if (sum + truckWeight <= weight) {
                        que.add(truckWeight);
                        sum += truckWeight;
                        answer++;
                        break;
                    } else {  //트럭이 올라올 수 없으니
                        que.add(0);
                        answer++;
                    }
                }
            }
        }
        
        return answer + bridge_length;
       
    }
}