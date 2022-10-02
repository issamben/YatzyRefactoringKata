import java.util.List;

public class Yatzy {

    public static int chance(DiceRoll diceRoll) {
        return diceRoll.sum();
    }

    public static int yatzy(DiceRoll diceRoll) {
        return diceRoll.isYatzy() ? 50 : 0;
    }

    public static Long ones(DiceRoll diceRoll) {
        return diceRoll.countDice(1);
    }

    public static Long twos(DiceRoll diceRoll) {
        return diceRoll.countDice(2) * 2;
    }

    public static Long threes(DiceRoll diceRoll) {
        return diceRoll.countDice(3) * 3;
    }

    public static Long fours(DiceRoll diceRoll) {
        return diceRoll.countDice(4) * 4;
    }

    public static Long fives(DiceRoll diceRoll) {
        return diceRoll.countDice(5) * 5;
    }

    public static Long sixes(DiceRoll diceRoll) {
        return diceRoll.countDice(6) * 6;
    }

    public static int onePair(DiceRoll diceRoll) {
        List<Integer> pairs = diceRoll.findPairs();
        return pairs.isEmpty() ? 0 : pairs.get(0) * 2;
    }

    public static int twoPair(DiceRoll diceRoll) {
        List<Integer> pairs = diceRoll.findPairs();
        return pairs.size() >= 2 ? pairs
            .stream()
            .mapToInt(pair -> pair * 2)
            .sum() : 0;
    }

    public static int threeOfAKind(DiceRoll diceRoll) {
        return diceRoll.getDiceWithCountGreaterThan(3) * 3;
    }

    public static int fourOfAKind(DiceRoll diceRoll) {
        return diceRoll.getDiceWithCountGreaterThan(4) * 4;
    }

    public static int smallStraight(DiceRoll diceRoll) {
        return diceRoll.isSmallStraight() ? 15 : 0;
    }

    public static int largeStraight(DiceRoll diceRoll) {
        return diceRoll.isLargeStraight() ? 20 : 0;
    }

    public static int fullHouse(DiceRoll diceRoll) {
        return diceRoll.isFullHouse() ? diceRoll.sum() : 0;
    }
}
