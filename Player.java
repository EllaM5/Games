
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
    public String toString() {
        return "Player " + playerIndex+1;
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
        if (hand.get(cardIndex).getSuit().equals(topCard.getSuit()) || hand.get(cardIndex).getValue().equals(topCard.getValue()))
        {
            hand.remove(cardIndex);
            return true;
        }
        return false;
    }
}
