abstract class Validator {
    public boolean processTurn(Player player, Board board, int n) {
        int roll = board.dice.roll();
        System.out.println(player.name + " rolled: " + roll);
        int newPos = player.position + roll;
        newPos = applyBoardRules(newPos, board);
        newPos= OutofBoardRules(newPos, player, n);
        newPos = nonCommonRules(newPos, player, n);
        player.position = newPos;
        System.out.println(player.name + " at: " + player.position);
        if (player.position >= n * n) {
            System.out.println(player.name + " wins!");
            return false;
        }
        return true;
    }

    private int applyBoardRules(int pos, Board board) {
        if (board.snakes.containsKey(pos)) {
            System.out.println("Bitten by snake!");
            return board.snakes.get(pos);
        }
        if (board.ladders.containsKey(pos)) {
            System.out.println("Climbed ladder!");
            return board.ladders.get(pos);
        }
        return pos;
    }
    int OutofBoardRules(int pos, Player player, int n) {
        int max = n * n;
        if (pos > max) {
            System.out.println("Invalid position");
            return player.position;
        }
        return pos;
    }

    abstract int nonCommonRules(int pos, Player player, int n);
}