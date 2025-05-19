
import java.util.Scanner;
import java.util.ArrayList;

public class Game
{
    private ArrayList<Card> deck;
    final private ArrayList<Player> players;
    private int playerCount;
    private ArrayList<Card> discard;
    Scanner input = new Scanner(System.in);
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
                deck.add(new Card(suits[i], values[j]));
            }
        }
        shuffleDeck();
        // Initialize players
        for (int i = 0; i < playerCount; i++) {
            players.add(new Player(i));
        }
        for (int i = 0; i< players.size();i++){
            ArrayList<Card> hand = new ArrayList<Card>();
            for (int j = 0; j < 10; j++) {
                hand.add(deck.remove((int)Math.random()*52));
            }
            players.get(i).setHand(hand);
        }
        discard.add(deck.remove(0));
        int turn = 0;
        while (!isWinner())
        {
            if (turn >= players.size()) {
                turn = 0;
            }
            if (deck.size()==0)
            {
                System.out.println("Deck is empty, remaking deck");
                remakeDeck();
            }
            System.out.println(players.get(turn) + "'s turn");
            System.out.println("Card on top ");
            PrintTopCard();
            if (turn == 0)
            {
                System.out.println("Which card do you want to place down? (Enter the index)");
                players.get(0).printHand();
                int cardIndex = input.nextInt();
                if (players.get(0).cardMatch(cardIndex, discard.get(0)))
                {
                    discardCard(players.get(0).getHand().remove(cardIndex));
                    System.out.println("Card placed down");
                }
                else
                {
                    System.out.println("Card does not match, drawing a card");
                    players.get(0).getHand().add(deck.remove(0));
                }
                System.out.println("Press enter to countie");
                input.nextLine();
                input.nextLine();
            }
            else{
                int index = players.get(turn).play(discard.get(0));
                if (index!=-1)
                {
                    discardCard(players.get(turn).getHand().remove(index));
                    System.out.println("Number of cards left: " + players.get(turn).getCardsLeft());
                    System.out.println("Card placed down, enter to countine");
                    input.nextLine();
                }
                else{
                    System.out.println("Card does not match, drawing a card");
                    players.get(turn).getHand().add(deck.remove(0));
                    System.out.println("Number of cards left: " + players.get(turn).getCardsLeft());
                    System.out.println("Press enter to countine");
                    input.nextLine();
                }
            }
            turn++;
        }
    }
    public void shuffleDeck() {
        ArrayList<Card> shuffledDeck = new ArrayList<Card>();
        while (deck.size() > 0) {
            int randomIndex = (int) (Math.random() * deck.size());
            shuffledDeck.add(deck.remove(randomIndex));
        }
        deck = shuffledDeck;
    }
    public void remakeDeck(){
        Card topCard = discard.remove(0);
        while (discard.size() > 0) {
            deck.add(discard.remove((int)Math.random()*discard.size()));
        }
        discard.add(topCard);
    }
    public void PrintTopCard()
    {
        System.out.println(discard.get(0));
    }
    public boolean isWinner()
    {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).Win()) {
                System.out.println("Player " + (i+1) + " wins!");
                return true;
            }
        }
        return false;
    }
    public void discardCard(Card card)
    {
        discard.add(0,card);
    }
}
