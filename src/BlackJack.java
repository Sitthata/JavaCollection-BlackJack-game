import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlackJack {

    private final Deck deck;
    private List<Card> playerHand;
    private List<Card> dealerHand;

    public BlackJack() {
        deck = new Deck();
        deck.shuffle();
        playerHand = new ArrayList<>();
        dealerHand = new ArrayList<>();
    }

    public void deal() {
        playerHand.add(deck.draw());
        dealerHand.add(deck.draw());
        playerHand.add(deck.draw());
        dealerHand.add(deck.draw());
    }

    public List<Card> getPlayerHand() {
        return playerHand;
    }

    public List<Card> getDealerHand() {
        return dealerHand;
    }

    public void printPlayerHand() {
        System.out.println("Player Cards: ");
        for (Card card : playerHand) {
            System.out.println(card.getRankName() + " of " + card.getSuit());
        }
    }

    public void printDealerHand() {
        System.out.println("Dealer Cards: ");
        for (Card card : dealerHand) {
            System.out.println(card.getRankName() + " of " + card.getSuit());
        }
    }

    public void hitPlayer() {
        System.out.println("Player hits!");
        playerHand.add(deck.draw());
    }

    public void hitDealer() {
        Random random = new Random();
        int dealerDeal = random.nextInt(2);
        if (dealerDeal == 1) {
            dealerHand.add(deck.draw());
            System.out.println("Dealer hits!");
        } else {
            System.out.println("Dealer stays!");
        }
    }

    public int getPlayerScore() {
        return playerHand.stream()
                .mapToInt(Card::getValue)
                .sum();
    }

    public int getDealerScore() {
        return dealerHand.stream()
                .mapToInt(Card::getValue)
                .sum();
    }

    public int determineWinner() {
        // Check if score is over 21
        int playerScore = getPlayerScore();
        int dealerScore = getDealerScore();

        if (playerScore > 21) {
            System.out.println("Player bust!");
            System.out.println("Dealer wins!");
            return 0;
        }

        if (dealerScore > 21) {
            System.out.println("Dealer bust!");
            System.out.println("Player wins!");
            return 1;
        }

        if (playerScore == dealerScore) {
            System.out.println("It's a tie!");
            return 1;
        }

        if (playerScore == 21) {
            System.out.println("Player has 21!");
            System.out.println("Player wins!");
            return 1;
        }

        if (dealerScore == 21) {
            System.out.println("Dealer has 21!");
            System.out.println("Dealer wins!");
            return 0;
        }

        if (playerScore > dealerScore) {
            System.out.println("Player has higher score!");
            System.out.println("Player wins!");
            return 1;
        }

        System.out.println("Dealer has higher score!");
        System.out.println("Dealer wins!");
        return 0;
    }

}
