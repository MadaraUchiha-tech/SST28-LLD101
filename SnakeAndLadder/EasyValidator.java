class EasyValidator extends Validator {
    @Override
    int nonCommonRules(int pos, Player player, int n) {
        return pos;
    }
}