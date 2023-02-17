import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        boolean gameOver = false; // loop ender

        Random dice = new Random();
        int roll1;
        int roll2;
        int sum; // stores sum of rolls later
        int point; // stores the point when it's rolled



        // game loop
        do {

            // generating random number
            roll1 = dice.nextInt(6) + 1;
            roll2 = dice.nextInt(6) + 1;
            sum = roll1 + roll2;

            // initial roll message
            System.out.println("Welcome to craps!\n" +
                    "Roll 1: " + roll1 + "\n" +
                    "Roll 2: " + roll2 + "\n" +
                    "Total: " + sum);

            // check if craps
            if (sum == 2 || sum == 3 || sum == 12) {

                // output result & ask if they want to play again
                System.out.println("You crapped out!\n" +
                        "Play again?");

                // check if input is 'Y'
                if (in.next().equalsIgnoreCase("Y")) {
                    gameOver = false;
                } else {
                    gameOver = true; // if not, end the loop
                }


                // they rolled a natural:
            } else if (sum == 7 || sum == 11) {

                // output result & ask if they want to play again
                System.out.println("Congrats, you rolled a natural!\n" +
                        "Play again?");

                // check if input is 'Y'
                if (in.next().equalsIgnoreCase("Y")) {
                    gameOver = false;
                } else {
                    gameOver = true; // if not, end the loop
                }


                // if else, it's point
            } else {

                // store it in a new variable
                point = sum;


                // start point loop
                do {

                    // output result
                    System.out.println("Trying for point: " + point);

                    // roll dice
                    roll1 = dice.nextInt(6) + 1;
                    roll2 = dice.nextInt(6) + 1;
                    sum = roll1 + roll2;

                    System.out.println("Roll 1: " + roll1 + "\n" +
                            "Roll 2: " + roll2 + "\n" +
                            "Total: " + sum);


                // end point loop
                } while (sum != point && sum != 7);

                // when it ends, check why it ended & print a message about it
                if (sum == point) {
                    System.out.println("You made point and won.\n" +
                            "Play again?");

                } else {
                    System.out.println("You rolled a 7 and lost.\n" +
                            "Play again?");

                }

                // regardless of if they won or lost, ask if they want to play again
                if (in.next().equalsIgnoreCase("Y")) {
                    gameOver = false; // keeps loop going
                } else {
                    gameOver = true; // ends loop
                }


            // end if
            }


            // send goodbye message if game is over
            if (gameOver) {
                System.out.println("See you next time!");
            }



        // end game loop
        } while (!gameOver);




        // end
    }
}