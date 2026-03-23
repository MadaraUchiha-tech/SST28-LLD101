import java.util.*;

class Board {
    int n;
    Map<Integer, Integer> snakes = new HashMap<>();
    Map<Integer, Integer> ladders = new HashMap<>();
    Dice dice = new Dice();

    public Board(int n) {
        this.n = n;
    }

    public void initialize() {
        Snakes.generate(snakes, n);
        Ladder.generate(ladders, n);
    }
}