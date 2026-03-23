public class Main {
    public static void main(String[] args) {
        Game game = GameFactory.getGame(10, 2, "hard");
        game.start();
    }
}