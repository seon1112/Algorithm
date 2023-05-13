import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int a : arr) {
            list.add(a);
        }

        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) { // 짝수 인덱스인 경우
                if (query[i] + 1 < list.size()) {
                    list.subList(query[i] + 1, list.size()).clear();
                }
            } else { // 홀수 인덱스인 경우
                if (query[i] > 0) {
                    list.subList(0, query[i]).clear();
                }
            }
        }

        int[] answer = new int[list.size()];
        for (int a = 0; a < answer.length; a++) {
            answer[a] = list.get(a);
        }
        return answer;
    }
}
