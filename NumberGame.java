
import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        int rounds = 0;
        int wins = 0;
        String playAgain;

        System.out.println("====================================");
        System.out.println("       WELCOME TO NUMBER GAME");
        System.out.println("====================================");

        do {

            // Generate a random number between 1 and 100
            int number = random.nextInt(100) + 1;

            int attempts = 7;
            boolean guessed = false;

            rounds++;

            System.out.println("\nRound: " + rounds);
            System.out.println("Guess a number between 1 and 100.");
            System.out.println("You have 7 attempts to guess the number.");

            // Repeat until the user guesses correctly or runs out of attempts
            while (attempts > 0) {

                System.out.print("\nEnter your guess: ");

                // Validate integer input
                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number.");
                    sc.next();
                    continue;
                }

                int guess = sc.nextInt();

                // Validate the guessing range
                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                attempts--;

                // Compare the guessed number with the random number
                if (guess == number) {

                    System.out.println("Congratulations! Your guess is correct.");
                    System.out.println("You guessed the number in " + (7 - attempts) + " attempts.");

                    score += attempts + 1;
                    wins++;
                    guessed = true;

                    break;
                }
                else if (guess > number) {

                    System.out.println("Too High! Try a smaller number.");

                }
                else {

                    System.out.println("Too Low! Try a bigger number.");

                }

                System.out.println("Attempts remaining: " + attempts);
            }

            // Display result if the user fails
            if (!guessed) {

                System.out.println("\nSorry! You have used all your attempts.");
                System.out.println("The correct number was: " + number);

            }

            // Ask the user whether they want another round
            System.out.print("\nDo you want to play again? (yes/no): ");
            playAgain = sc.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        // Display final game summary
        System.out.println("\n====================================");
        System.out.println("             GAME SUMMARY");
        System.out.println("====================================");

        System.out.println("Total Rounds Played: " + rounds);
        System.out.println("Rounds Won: " + wins);
        System.out.println("Rounds Lost: " + (rounds - wins));
        System.out.println("Total Score: " + score);

        System.out.println("\nThank you for playing!");

        sc.close();
    }
}
