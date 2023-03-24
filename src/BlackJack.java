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

        if (getDealerScore() < 10) {
            dealerDeal = 1;
        }

        if (dealerDeal == 1) {
            dealerHand.add(deck.draw());
            System.out.println("Dealer hits!");
        } else {
            System.out.println("Dealer stays!");
        }
    }

    private int getScore(List<Card> hand) {
        int score = hand.stream()
                .mapToInt(Card::getValue)
                .sum();
        if (hand.stream().anyMatch(card -> card.getRankName().equals("ACE")) && score > 21) {
            score -= 10;
        }
        return score;
    }

    public int getPlayerScore() {
        return getScore(playerHand);
    }

    public int getDealerScore() {
        return getScore(dealerHand);
    }


    public void clearHand() {
        playerHand.clear();
        dealerHand.clear();
    }

    public int determineWinner() {
        // Check if score is over 21
        int playerScore = getPlayerScore();
        int dealerScore = getDealerScore();

        int result = (playerScore > 21) ? 0 :
                (dealerScore > 21) ? 1 :
                        (playerScore > dealerScore) ? 1 :
                                (playerScore < dealerScore) ? 0 :
                                        1; // In case of a tie, player wins

        String message = (playerScore == dealerScore) ? "It's a tie!" :
                (playerScore == 21) ? "Player has 21! Player wins!" :
                        (dealerScore == 21) ? "Dealer has 21! Dealer wins!" :
                                (result == 1) ? "Player has higher score! Player wins!" :
                                        "Dealer has higher score! Dealer wins!";

        System.out.println(message);
        return result;
    }
}
