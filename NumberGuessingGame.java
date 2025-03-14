import java.util.Scanner;
public class NumberGuessingGame {
    static ValueHolder valueHolder;
    static int playerScore;

    public static void main(String[] args) {
        NumberGuessingGame numberGuessingGame = new NumberGuessingGame();
    }

    NumberGuessingGame() {
        playerScore = 0;
        valueHolder = promptUserDifficulty();
        playGame();
    }

    // lets the player choose his guessed number
    public static int promptUserGuess() {
        Scanner userGuess = new Scanner(System.in);
        System.out.println("Guess the Number:");
        int guessedNumber = userGuess.nextInt();
        if(guessedNumber < 0) {
            System.out.println("The number has to be in the target range");
            promptUserGuess();
        }
        if(valueHolder.value2 < guessedNumber){
            System.out.println("The number has to be in the target range");
            promptUserGuess();
        }
        return guessedNumber;
    }
        // Returns a random number from 1 to 100 multiply with the difficulty
    public static int generateTargetNumber() {
            int targetNumber = (int)(Math.random() * (101 * valueHolder.value1));
            return targetNumber;
    }
    // plays a round of the game
    public static void playGame() {
        int targetNumber = generateTargetNumber();
        for(int round = 0;round < 15;round ++) {
           int userInput = promptUserGuess();
           if(userInput > targetNumber) {

               System.out.println("The number is smaller");

               if(userInput < targetNumber + 10){
                   System.out.println("and you are close!");
               }else if(userInput < targetNumber + 20) {
                   System.out.println("you are warm");
               }

           } else if(userInput < targetNumber) {

                System.out.println("The number is higher");

               if(userInput > targetNumber - 10) {
                   System.out.println("and you are close!");
               }else if(userInput > targetNumber - 20){
                   System.out.println(" you are warm!");
               }


           } else if(userInput == targetNumber) {
               System.out.println("Congratulations you won");
               System.out.println("It took you " + (round + 1) + " guesses to get the right number");
               playerScore++;
               System.out.println("Your current Score is: " + playerScore);
               break;
           }
            if(round == 14) {
                System.out.println("You Lose");
                System.out.println("The number was " + targetNumber);
                System.out.println("Your current Score is: " + playerScore);
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
            if("yes".equals(userAnswer.trim())) {
                playGame();
            } else if("no".equals(userAnswer.trim())){
                return;
            } else {
                System.out.println("Please answer yes or no.");
                playAgain();
            }
        }
        // Ask the player for the preferred difficulty
        public static ValueHolder promptUserDifficulty() {
            Scanner chosenDifficulty = new Scanner(System.in);
            System.out.println("Choose your difficulty(choose 1 for the standard difficulty):");
            int difficulty = chosenDifficulty.nextInt();
            if(0 > difficulty) {
                System.out.println("please use a positive number");
                promptUserDifficulty();
            } else {
                System.out.println("the number is between 0 and " + difficulty * 101);
            }
            int maxGuess = difficulty * 101;
            return new ValueHolder(difficulty, maxGuess);
        }

    }