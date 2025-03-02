package problems.lv2;

public class ServerScalingCount {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] server = new int[24];

        for (int i = 0; i < players.length; i++) {
            if (players[i] >= (server[i] + 1) * m) {
                int required = players[i] / m - server[i];
                for (int j = i; j < Math.min(24, i + k); j++) {
                    server[j] += required;
                }
                answer += required;
            }
        }

        return answer;
    }
}
