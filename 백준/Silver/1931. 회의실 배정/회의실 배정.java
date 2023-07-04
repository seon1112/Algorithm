


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Meeting[] meetings = new Meeting[n];
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            meetings[i] = new Meeting(start, end);
        }
        //Arrays.sort(meetings, Comparator.comparingInt(m -> m.end));
        Arrays.sort(meetings, Comparator.comparingInt((Meeting m) -> m.end).thenComparingInt(m -> m.start));
        int answer = 1;
        int end = meetings[0].end;
        for (int i = 1; i < n; i++) {
            if (meetings[i].start >= end) {
                end = meetings[i].end;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
