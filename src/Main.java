import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        blackJack();
    }

    public static void blackJack() {

        BlackJack blackJack = new BlackJack();
        Scanner sc = new Scanner(System.in);


        // Dealing Cards

        System.out.println("Welcome to BlackJack!");

        boolean playing = true;
        int choice;

        while(playing) {

            System.out.println("Player hand: " + blackJack.getPlayerScore());
            blackJack.deal();
            System.out.println("Dealing hands...");
            System.out.println("Would you like to Hit or Stay?");
            System.out.println("1 : Hit\n2 : Stay");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    blackJack.hitPlayer();
                    blackJack.hitDealer();
                    System.out.println("Player hand: " + blackJack.getPlayerScore());
                    System.out.println("Dealer hand: " + blackJack.getDealerScore());
                    blackJack.determineWinner();
                    break;
                case 2:
                    blackJack.hitDealer();
                    System.out.println("Player hand: " + blackJack.getPlayerScore());
                    System.out.println("Dealer hand: " + blackJack.getDealerScore());
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
            System.out.println("Would you like to play again? Type 1 for yes, 2 for no.");
            playing = sc.nextInt() == 1;
            System.out.println();
        }


    }
}