
import java.util.Scanner;
import java.util.ArrayList;

public class Game
{
    private ArrayList<Card> deck;
    final private ArrayList<Player> players;
    private int playerCount;
    private ArrayList<Card> discard;
    private int handSize;
    Scanner input = new Scanner(System.in);
    public Game(int playerCount, int handSize)
    {
        this.playerCount = playerCount;
        deck = new ArrayList<Card>();
        players = new ArrayList<Player>();
        discard = new ArrayList<Card>();
        this.handSize = handSize;
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
        if (handSize >52/playerCount) {
            System.out.println("Hand size is too large, setting to default");
            handSize = (52/playerCount)-2;
        }
        for (int i = 0; i< players.size();i++){
            ArrayList<Card> hand = new ArrayList<Card>();
            for (int j = 0; j < handSize; j++) {
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
                System.out.println("Deck remade, press enter to continue");
                input.nextLine();
            }
            System.out.println(players.get(turn) + "'s turn");
            System.out.println("Card on top ");
            PrintTopCard();
            input.nextLine();
            if (turn == 0)
            {
                System.out.println("Which card do you want to place down? (Enter the index)");
                players.get(0).printHand();
                int cardIndex = input.nextInt();
                input.nextLine();
                while (cardIndex < 0 || cardIndex >= players.get(0).getCardsLeft())
                {
                    System.out.println("Invalid index, try again");
                    cardIndex = input.nextInt();
                    input.nextLine();
                }
                if (players.get(0).cardMatch(cardIndex, discard.get(0)))
                {
                    if (players.get(0).getCard(cardIndex).getValue().equals("8"))
                    {
                        System.out.println("You put down a 8 card, what suit do you want to change to? (Spades,Clubs,Diamonds,Hearts)");
                        String suit = input.nextLine();
                        players.get(0).getCard(cardIndex).setWild(suit);
                        
                    }
                    discardCard(players.get(0).getHand().remove(cardIndex));
                    System.out.println("Card placed down");
                }
                else
                {
                    System.out.println("Card does not match, drawing a card");
                    players.get(0).getHand().add(deck.remove(0));
                }
                System.out.println("Press enter to continue");
                input.nextLine();
            }
            else{
                int index = players.get(turn).play(discard.get(0));
                if (index!=-1)
                {
                    discardCard(players.get(turn).getHand().remove(index));
                    System.out.println("Card placed down");
                    if (discard.get(0).getValue().equals("8"))
                    {
                        discard.get(0).setWild(players.get(turn).largestSuit());
                        System.out.println("Changed suit to " + discard.get(0).getWild());  
                    }
                    System.out.println("Number of cards left: " + players.get(turn).getCardsLeft());
                    System.out.println("New top card: " + discard.get(0));
                }
                else{
                    System.out.println("Card does not match, drawing a card");
                    players.get(turn).getHand().add(deck.remove(0));
                    System.out.println("Number of cards left: " + players.get(turn).getCardsLeft());
                }
                System.out.println("Press enter to continue");
                input.nextLine();
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
