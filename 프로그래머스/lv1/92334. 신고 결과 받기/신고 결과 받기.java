import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String[] idList, String[] report, int k) {
        int[] answer = new int[idList.length];
        Map<String, List<String>> reportsByUser = new HashMap<>();
        Map<String, Integer> reportCounts = new HashMap<>();
        for (String userId : idList) {
            reportsByUser.put(userId, new ArrayList<>());
            reportCounts.put(userId, 0);
        }
        for (String reportLine : report) {
            String[] parts = reportLine.split(" ");
            String reporterId = parts[0];
            String reportedId = parts[1];
            List<String> reports = reportsByUser.get(reporterId);
            if (!reports.contains(reportedId)) {
                reports.add(reportedId);
                reportCounts.put(reportedId, reportCounts.get(reportedId) + 1);
            }
        }
        List<String> bannedUsers = new ArrayList<>();
        for (String userId : idList) {
            if (reportCounts.get(userId) >= k) {
                bannedUsers.add(userId);
            }
        }
        for (int i = 0; i < idList.length; i++) {
            for (String bannedUser : bannedUsers) {
                List<String> reports = reportsByUser.get(idList[i]);
                if (reports.contains(bannedUser)) {
                    answer[i]++;
                }
            }
        }
        return answer;
    }
}
