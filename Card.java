public class Card {
    private String suit;
    private String vaule;
    private String wild;
    public Card(String suit, String value) {
        this.suit = suit;
        this.vaule = value;
        wild = "";
    }
    public String toString() {
        if (!wild.equals(""))
        {
            return vaule + " of " + suit + "(" + wild + ")";
        }
        return vaule + " of " + suit;
    }
    public String getSuit() {
        return suit;
    }
    public String getValue() {
        return vaule;
    }
    public String getWild()
    {
        return wild;
    }
    public void setWild(String s)
    {
        wild = s;
    }
}
