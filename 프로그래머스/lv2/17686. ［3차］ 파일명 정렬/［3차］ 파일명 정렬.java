import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
         Arrays.sort(files, (a1, a2) -> {
            String a = "";
            String b = "";
            String c = "";
            String d = "";

            // a1 처리
            int idx = 0;
            while (idx < a1.length() && !Character.isDigit(a1.charAt(idx))) {
                a += a1.charAt(idx);
                idx++;
            }
            while (idx < a1.length() && Character.isDigit(a1.charAt(idx))) {
                c += a1.charAt(idx);
                idx++;
            }

            // a2 처리
            idx = 0;
            while (idx < a2.length() && !Character.isDigit(a2.charAt(idx))) {
                b += a2.charAt(idx);
                idx++;
            }
            while (idx < a2.length() && Character.isDigit(a2.charAt(idx))) {
                d += a2.charAt(idx);
                idx++;
            }

            a = a.toLowerCase();
            b = b.toLowerCase();

            if (a.equals(b)) {
                return Integer.parseInt(c) - Integer.parseInt(d);
            } else {
                return a.compareTo(b);
            }
        });

        return files;

    }
}