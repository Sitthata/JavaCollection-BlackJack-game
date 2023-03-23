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
        for(Card card : playerHand) {
            System.out.println(card.getRank() + " of " + card.getSuit());
        }
    }

    public void printDealerHand() {
        System.out.println("Dealer Cards: ");
        for(Card card : dealerHand) {
            System.out.println(card.getRank() + " of " + card.getSuit());
        }
    }

    public void hitPlayer() {
        playerHand.add(deck.draw());
    }

    public void hitDealer() {
        Random random = new Random();
        int dealerDeal = random.nextInt(2);
        if(dealerDeal == 1) {
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

    public void determineWinner() {
        // Check if score is over 21
        if(getPlayerScore() > 21){
            System.out.println("Player bust!");
        }
        // Check if dealer score is over 21
        if(getDealerScore() > 21) {
            System.out.println("Dealer bust!");
        };
        // Check if player score is higher than dealer score
        if(getPlayerScore() > getDealerScore()) {
            System.out.println("Player wins!");
        } else {
            System.out.println("Dealer wins!");
        }
    }
}
