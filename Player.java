
import java.util.ArrayList;
public class Player {
    private ArrayList<Card> hand;
    private int playerIndex;
    public Player(int playerIndex) {
        hand = new ArrayList<Card>();
        this.playerIndex = playerIndex;
    }
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
    public int getCardsLeft() {
        return hand.size();
    }
    public boolean Win()
    {
        if(hand.size() == 0)
        {
            return true;
        }
        return false;
    }
    public ArrayList<Card> getHand() {
        return hand;
    }
    public void printHand()
    {
        System.out.println("Your hand:");
        for (int i = 0; i < hand.size(); i++) {
            System.out.println(i + " " + hand.get(i));
        }
    }
    public boolean cardMatch(int cardIndex, Card topCard)
    {
        // need to work on making where if the card is wild then it has to match wild
        if ((hand.get(cardIndex).getSuit().equals(topCard.getWild())&& hand.get(cardIndex).getSuit().equals(topCard.getSuit())) || hand.get(cardIndex).getValue().equals(topCard.getValue()||hand.get(cardIndex).getVaule().equals("8")))
        {
            return true;
        }
        return false;
    }
    public int play(Card topCard)
    {
        for (int i = 0;i<hand.size();i++)
        {
            if(cardMatch(i, topCard))
            {
                return i;
            }
        }
        return -1;
    }
    public Card getCard(int index)
    {
        return hand.get(index);
    }
    public String toString() {
        return "Player " + (playerIndex+1);
    }
}
