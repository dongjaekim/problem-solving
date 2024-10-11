package problems.lv2;

class DecompressString {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i = 1; i <= s.length() / 2; i++) {
            String prev = "";
            int tempCnt = 1;
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < s.length(); j += i) {
                String compare = s.substring(j, Math.min(j + i, s.length()));

                if (prev.isEmpty())
                    prev = compare;
                else if (prev.equals(compare))
                    tempCnt++;
                else {
                    if (tempCnt > 1)
                        sb.append(tempCnt);

                    sb.append(prev);
                    prev = compare;
                    tempCnt = 1;
                }
            }

            if (tempCnt > 1) {
                sb.append(tempCnt);
            }
            sb.append(prev);

            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
}
