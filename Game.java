
import java.util.ArrayList;
import java.util.logging.Handler;

public class Game
{
    private ArrayList<Card> deck;
    private ArrayList<Player> players;
    private int playerCount;
    private ArrayList<Card> discard;
    public Game(int playerCount)
    {
        this.playerCount = playerCount;
        deck = new ArrayList<Card>();
        players = new ArrayList<Player>();
        discard = new ArrayList<Card>();
    }
    public void startGame()
    {
        // Initialize the deck of cards
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < values.length; j++) {
                deck.add(new Card(suits[i], values[j]);
            }
        }

        // Initialize players
        for (int i = 0; i < playerCount; i++) {
            players.add(new Player());
        }
        for (int i = 0; i< players.size();i++){
            ArrayList<Card. hand = new ArrayList<Card>();
            for (int j = 0; j < 5; j++) {
                Handler.add(deck.remove(Math.random()*52));
            }
            players.get(i).setHand(hand);

        }
        public void shuffleDeck() {
            
        }
    }
}
