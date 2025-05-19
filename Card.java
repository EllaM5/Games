public class Card {
    private String suit;
    private String vaule;
    public Card(String suit, String value) {
        this.suit = suit;
        this.vaule = value;
    }
    public String toString() {
        return vaule + " of " + suit;
    }
    public String getSuit() {
        return suit;
    }
    public String getValue() {
        return vaule;
    }
}
