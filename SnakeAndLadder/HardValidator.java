class HardValidator extends Validator {
    // I implemented a custom hard rule that a position that is n is not valid
    @Override
    int nonCommonRules(int pos, Player player, int n) {
        if (pos==n) {
            System.out.println("Invalid position");
            return player.position;
        }
        return pos;
    }
}