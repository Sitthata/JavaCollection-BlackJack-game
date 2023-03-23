
public class Main {
    public static void main(String[] args) {

        Deck deck = new Deck();

        for(var card : deck.getCards()) {
            System.out.println(card);
        }

    }
}