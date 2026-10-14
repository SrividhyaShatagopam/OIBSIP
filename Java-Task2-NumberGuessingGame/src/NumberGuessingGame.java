import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int round = 1;
        int totalAttempts = 0;

        System.out.println("=================================");
        System.out.println("      NUMBER GUESSING GAME");
        System.out.println("=================================");

        boolean playAgain = true;

        while (playAgain) {

            int number = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessed = false;

            System.out.println("\nRound " + round);
            System.out.println("I have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    scanner.next();
                    continue;
                }

                int guess = scanner.nextInt();
                attempts++;
                totalAttempts++;

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                }
                else if (guess > number) {
                    System.out.println("Too High!");
                }
                else if (guess < number) {
                    System.out.println("Too Low!");
                }
                else {
                    System.out.println("Correct!");
                    System.out.println("You guessed the number in "
                            + attempts + " attempts.");
                    guessed = true;
                    break;
                }

                System.out.println("Attempts remaining: "
                        + (maxAttempts - attempts));
            }

            if (!guessed) {
                System.out.println("\nYou Lost!");
                System.out.println("The correct number was: " + number);
            }

            System.out.println("\nRound " + round
                    + " completed in " + attempts + " attempts.");

            System.out.print("\nDo you want to play again? (yes/no): ");

            String answer = scanner.next();

            if (answer.equalsIgnoreCase("yes")) {
                round++;
            } else {
                playAgain = false;
            }
        }

        System.out.println("\n=================================");
        System.out.println("           GAME SUMMARY");
        System.out.println("=================================");
        System.out.println("Total rounds played: " + round);
        System.out.println("Total attempts: " + totalAttempts);
        System.out.println("Thank you for playing!");

        scanner.close();
    }
}
