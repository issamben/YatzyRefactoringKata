import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.Arrays.asList;
import static java.util.Collections.reverseOrder;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public class DiceRoll {

    private final List<Integer> dices;

    public DiceRoll(int d1, int d2, int d3, int d4, int d5) {
        this.dices = Arrays.asList(d1, d2, d3, d4, d5);
    }

    public int sum() {
        return dices.stream().mapToInt(Integer::intValue).sum();
    }

    public Long countDice(int dice) {
        return dices.stream().collect(groupingBy(identity(), Collectors.counting())).getOrDefault(dice, 0L);
    }

    public boolean isYatzy() {
        return dices
            .stream()
            .collect(groupingBy(identity(), Collectors.counting()))
            .values()
            .stream()
            .anyMatch(count -> count == 5);
    }

    public List<Integer> findPairs() {
        return dices
            .stream()
            .collect(groupingBy(identity(), Collectors.counting()))
            .entrySet()
            .stream()
            .filter(e -> e.getValue() >= 2)
            .map(Map.Entry::getKey)
            .sorted(reverseOrder())
            .collect(toList());
    }

    public int getDiceWithCountGreaterThan(int n) {
        return dices
            .stream()
            .collect(groupingBy(identity(), Collectors.counting()))
            .entrySet()
            .stream()
            .filter(e -> e.getValue() >= n)
            .map(Map.Entry::getKey)
            .findFirst()
            .orElse(0);
    }

    public boolean isSmallStraight() {
        return sort().equals(Arrays.asList(1, 2, 3, 4, 5));
    }

    private List<Integer> sort() {
        return dices.stream().sorted().collect(toList());
    }

    public boolean isLargeStraight() {
        return sort().equals(asList(2, 3, 4, 5, 6));
    }

    public boolean isFullHouse() {
        boolean isThreeOfAKind = getDiceWithCountGreaterThan(3) != 0;
        boolean isPair = !findPairs().isEmpty();
        boolean isYatzy = isYatzy();
        return isThreeOfAKind && isPair && !isYatzy;
    }
}
