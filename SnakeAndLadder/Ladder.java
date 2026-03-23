import java.util.*;

class Ladder {
    public static void generate(Map<Integer, Integer> ladders, int n) {
        Random random = new Random();
        Set<Integer> usedStarts = new HashSet<>();

        while (ladders.size() < n) {
            int start = random.nextInt(98) + 1;
            int end = random.nextInt(100 - start) + start + 1;

            if (start != end && !usedStarts.contains(start)) {
                ladders.put(start, end);
                usedStarts.add(start);
            }
        }
    }
}