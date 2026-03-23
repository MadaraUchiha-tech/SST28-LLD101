class GameFactory {
    public static Game getGame(int n, int players, String difficulty) {
        Board board = new Board(n);
        board.initialize();

        PlayerFactory pf = new PlayerFactory();
        Validator validator;

        if (difficulty.equalsIgnoreCase("easy")) {
            validator = new EasyValidator();
        } else {
            validator = new HardValidator();
        }

        return new Game(n, players, board, pf.getPlayers(players), validator);
    }
}