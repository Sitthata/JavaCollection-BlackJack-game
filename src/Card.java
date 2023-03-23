import card_enum.Rank;
import card_enum.Suit;


public class Card {
    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return rank.getValue();
    }

    public String getRankName() {
        return rank.name();
    }

    public boolean equals(Object card) {
        if(!(card instanceof Card)) return false;
        Card otherCard = (Card) card;
        return this.rank == otherCard.rank && this.suit == otherCard.suit;
    }

    @Override
    public String toString() {
        return String.format("%s of %s", rank, suit);
    }
}
