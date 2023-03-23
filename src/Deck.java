import card_enum.Rank;
import card_enum.Suit;

import java.util.*;

public class Deck {

    private final List<Card> cards = new ArrayList<>();

    public Deck() {
        // Create a deck of cards in sorted order
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public int size() {
        return cards.size();
    }

    public Card draw() {
        return cards.remove(0);
    }

    public Card draw(int count){
        // Remove the Cards from the front of the deck
        return cards.remove(count);
    }

    public void shuffle() {
        // Shuffle the deck
        Collections.shuffle(cards);
    }

    public List<Card> getCardByRank(Card card) {
        return cards.stream()
                .filter(c -> c.getRank() == card.getRank())
                .toList();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Deck{");
        sb.append("cards=").append(cards);
        sb.append('}');
        return sb.toString();
    }


}
