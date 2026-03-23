import java.util.*;

class PlayerFactory {
    public List<Player> getPlayers(int count) {
        List<Player> list = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            list.add(new Player("Player" + i));
        }

        return list;
    }
}