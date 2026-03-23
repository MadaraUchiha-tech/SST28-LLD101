import java.util.Random;

class Dice {
    Random num = new Random();
    public int roll() {
        return num.nextInt(6) + 1;
    }
}