package problems.lvl;

class NumberPartner {
    public String solution(String X, String Y) {
        int[] xIntegerCount = new int[10];
        int[] yIntegerCount = new int[10];

        for (int i = 0; i < X.length(); i++) {
            xIntegerCount[X.charAt(i) - '0']++;
        }
        for (int i = 0; i < Y.length(); i++) {
            yIntegerCount[Y.charAt(i) - '0']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (xIntegerCount[i] > 0 && yIntegerCount[i] > 0) {
                int count = Math.min(xIntegerCount[i], yIntegerCount[i]);
                while (count > 0) {
                    sb.append(i);
                    count--;
                }   
            }
        }        
        
        String answer = sb.toString();
        if (answer.length() > 0 && answer.replaceAll("0", "").length() == 0)
            answer = "0";
        
        return "".equals(answer) ? "-1" : answer;
    }
}
