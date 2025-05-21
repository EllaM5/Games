import java.util.Scanner;
public class GameTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many players are there? (2-8)");
        int playerCount = scanner.nextInt();
        System.out.println("How many cards per player?");
        int handSize = scanner.nextInt();
        Game game = new Game(playerCount,handSize);
        game.startGame();
    }
}
