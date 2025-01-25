package problems.lv2;

public class PuzzleGameChallenge {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 100000;
        int right = 0;
        for (int i = 0; i < diffs.length; i++) {
            if (left > diffs[i])
                left = diffs[i];
            if (right < diffs[i])
                right = diffs[i];
        }

        while (left <= right) {
            int mid = (right + left) / 2;
            long temp = 0L;

            for (int i = 0; i < diffs.length; i++) {
                if (mid - diffs[i] >= 0) {
                    temp += times[i];
                } else {
                    temp += (times[i] + times[i - 1]) * (diffs[i] - mid) + times[i];
                }

                if (temp > limit) {
                    break;
                }
            }

            if (temp > limit) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
