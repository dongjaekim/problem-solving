class SumOfSuccessiveNumbers {
    public int[] solution(int num, int total) {
        int n = total;
        for (int i = 1; i < num; i++) {
            n -= i;
        }
        n /= num;
        
        int[] answer = new int[num];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = n++;            
        }
        
        return answer;
    }
}
