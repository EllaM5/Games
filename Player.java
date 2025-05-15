
import java.util.ArrayList;
public class Player {
    private ArrayList<Card> hand;
    public Player() {
        hand = new ArrayList<Card>();
    }
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
}
