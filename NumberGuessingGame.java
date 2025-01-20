import java.util.Scanner;
public class NumberGuessingGame {
    public static void main(String[] args) {
        playGame();

    }

    // lets the player choose his guessed number
    public static int promptUserGuess() {
        Scanner userGuess = new Scanner(System.in);
        System.out.println("Guess the Number:");
        int guessedNumber = userGuess.nextInt();
        return guessedNumber;
    }
        // Returns a random number from 1 to 100
    public static int generateTargetNumber() {
            int targetNumber = (int)(Math.random() * 101);
            return targetNumber;
    }

    public static void playGame() {
        int targetNumber = generateTargetNumber();
        for(int round = 0;round < 10;round ++) {
           int userInput = promptUserGuess();
           if(userInput > targetNumber) {
               System.out.println("The number is smaller");
           } else if(userInput < targetNumber) {
                System.out.println("The number is higher");
           } else if(userInput == targetNumber) {
               System.out.println("Congratulations you won");
               System.out.println("It took you " + (round + 1) + " guesses to get the right number");
               break;
           }
            if(round == 9) {
                System.out.println("You Lose");
                System.out.println("The number was" + targetNumber);
                break;
            }
           }
            playAgain();

        }
            // ask the player if they want to play again.
        public static void playAgain() {
            Scanner playAgain = new Scanner(System.in);
            System.out.println("Do you want to play again yes/no?");
            String userAnswer = playAgain.nextLine();
            if("yes".equals(userAnswer)) {
                playGame();
            } else if(userAnswer.equals(userAnswer)){
                return;
            } else {
                System.out.println("Please answer yes or no.");
                playAgain();
            }
        }

    }