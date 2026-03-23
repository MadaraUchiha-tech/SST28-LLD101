import java.util.*;

class Snakes {
    public static void generate(Map<Integer, Integer> snakes, int n) {
        Random random = new Random();
        Set<Integer> usedStarts = new HashSet<>();

        while (snakes.size() < n) {
            int start = random.nextInt(99) + 2;
            int end = random.nextInt(start - 1) + 1;

            if (start != end && !usedStarts.contains(start)) {
                snakes.put(start, end);
                usedStarts.add(start);
            }
        }
    }
}