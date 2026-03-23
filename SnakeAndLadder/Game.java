import java.util.List;

class Game {
    int n, players;
    Board board;
    List<Player> playerList;
    Validator validator;
    boolean running;

    public Game(int n, int players, Board board, List<Player> playerList, Validator validator) {
        this.n = n;
        this.players = players;
        this.board = board;
        this.playerList = playerList;
        this.validator = validator;
        this.running = true;
    }

    public void start() {
        int turn = 0;
        while (running) {
            Player current = playerList.get(turn % players);
            System.out.println("\n" + current.name + "'s turn");
            running = validator.processTurn(current, board, n);
            turn++;
        }
    }
}