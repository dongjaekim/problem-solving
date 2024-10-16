import java.util.*;

class FindPrimeNumberCombination {
    Map<Integer, Boolean> primeNumber = new HashMap<>();
    Set<Integer> numberSet = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        findPossibleNumbers(new boolean[numbers.length()], numbers, "");
        // primeNumber((int) Math.pow(10, numbers.length()));
        
        for (int number : numberSet) {
            // if (primeNumber.get(number) != null)
            //     answer++;
            if (isPrime(number))
                answer++;
        }
        return answer;
    }
    
    public boolean isPrime(int n) {
        if (n == 0 || n == 1)
            return false;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) 
                return false;
        }
        
        return true;
    }
    
    public void findPossibleNumbers(boolean[] visited, String numbers, String subStr) {
        if (numbers.length() == subStr.length()) {
            numberSet.add(Integer.parseInt(subStr));
            return;
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            StringBuilder sb = new StringBuilder();
            sb.append(subStr);
            sb.append(numbers.charAt(i));
            numberSet.add(Integer.parseInt(sb.toString()));
            findPossibleNumbers(visited, numbers, sb.toString());
            visited[i] = false;
        }
        
    }
    
    public void primeNumber(int n) {
        boolean[] isPrime = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            if (!isPrime[i]) {
                primeNumber.put(i, true);
                int j = 2;
                while (i * j <= n) {
                    isPrime[i * j] = true;
                    j++;
                }
            }
        }
    }
}
