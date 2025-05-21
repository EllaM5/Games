
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
        if (hand.get(cardIndex).getSuit().equals(topCard.getWild()) || hand.get(cardIndex).getSuit().equals(topCard.getSuit()) || hand.get(cardIndex).getValue().equals(topCard.getValue()) || hand.get(cardIndex).getValue().equals("8"))
        {
            if (!topCard.getWild().equals("") && !hand.get(cardIndex).getSuit().equals(topCard.getWild()))
            {
                return false;
            }
            return true;
        }
        return false;
    }
    public int play(Card topCard)
    {
        int last = -1;
        for (int i = 0;i<hand.size();i++)
        {
            if(cardMatch(i, topCard))
            {
                if (hand.get(i).getValue().equals("8"))
                {
                    last = i;
                }
                else{
                    return i;
                }
            }
        }
        if (last!=-1)
        {
            return last;
        }
        return -1;
    }
    public String largestSuit()
    {
        int max = 0;
        int index = 0;
        int longest = 0;
        for (int i = 1; i<hand.size();i++)
        {
            if (hand.get(i).getSuit().equals(hand.get(i-1).getSuit()))
            {
                longest++;
                if (longest == max)
                {
                    max = longest;
                    index  = i;
                }
            }
            else{
                longest = 0;
            }
        }
        return hand.get(index).getSuit();
    }
    public Card getCard(int index)
    {
        return hand.get(index);
    }
    public String toString() {
        return "Player " + (playerIndex+1);
    }
}
