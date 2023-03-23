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
        cards.remove(0);
        return cards.get(0);
    }

    public List<Card> draw(int count){
        if(count < cards.size()) return null;
        if(count > cards.size()) count = cards.size();
        // Remove the Cards from the front of the deck
        cards.removeAll(cards.subList(0, count));
        return cards.subList(0, count);
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
