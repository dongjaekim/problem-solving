package problems.easy;

public class GuessNumberHigherOrLower374 {
    static class GuessGame {
        private int pick;
        private int maxVal = Integer.MAX_VALUE;
        private int minVal = 0;

        public GuessGame(int pick) {
            this.pick = pick;
        }

        public int guess(int n) {
            if (n > pick)
                return -1;
            else if (n < pick)
                return 1;
            else
                return 0;
        }

        public int guessNumber(int n) {
            System.out.println("n = " + n);
            int guess = guess(n);
            int pick = 0;

            if (guess == 0)
                pick = n;
            else if (guess == -1) {
                maxVal = n;
                pick = guessNumber(n - (n - minVal) / 2);
            } else if (guess == 1) {
                minVal = n;
                pick = guessNumber(n + (maxVal - n) / 2);
            }


            return pick;
        }

    }


    public static void main(String[] args) {
        GuessGame guessGame1 = new GuessGame(6);
        int p1 = guessGame1.guessNumber(10);
        System.out.println("p1 = " + p1);

        GuessGame guessGame2 = new GuessGame(1);
        int p2 = guessGame2.guessNumber(1);
        System.out.println("p2 = " + p2);

        GuessGame guessGame3 = new GuessGame(1);
        int p3 = guessGame3.guessNumber(2);
        System.out.println("p3 = " + p3);

        GuessGame guessGame4 = new GuessGame(1702766719);
        int p4 = guessGame4.guessNumber(2126753390);
        System.out.println("p4 = " + p4);
    }
}
