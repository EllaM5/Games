import java.util.Scanner;
public class GameTester {
    public static void main(String[] args) {
        System.out.println("How many players are there?");
        Scanner scanner = new Scanner(System.in);
        int playerCount = scanner.nextInt();
        Game game = new Game(playerCount);
        game.startGame();
    }
}
