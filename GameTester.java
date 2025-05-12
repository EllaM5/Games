public class GameTester {
    public static void main(String[] args) {
        Game game = new Game(100, 2, 3);
        System.out.println("Score: " + game.getScore());
        System.out.println("Level: " + game.getLevel());
        System.out.println("Lives: " + game.getLives());
    }
}
