import java.util.List;

public class Yatzy {

    public static int chance(DiceRoll diceRoll) {
        return diceRoll.sum();
    }

    public static int yatzy(DiceRoll diceRoll) {
        if (diceRoll.isYatzy()) {
            return 50;
        }
        return 0;
    }

    public static Long ones(DiceRoll diceRoll) {
        return diceRoll.countDice(1);
    }

    public static Long twos(DiceRoll diceRoll) {
        return diceRoll.countDice(2) * 2;
    }

    public static Long threes(DiceRoll diceRoll) {
        return  diceRoll.countDice(3) * 3;
    }

    public static Long fours(DiceRoll diceRoll) {
        return  diceRoll.countDice(4) * 4;
    }

    public static Long fives(DiceRoll diceRoll) {
        return  diceRoll.countDice(5) * 5;
    }

    public static Long sixes(DiceRoll diceRoll) {
        return  diceRoll.countDice(6) * 6;
    }

    public static int onePair(DiceRoll diceRoll) {
        List<Integer> pairs = diceRoll.findPairs();
        if (pairs.isEmpty()) {
            return 0;
        }  else {
            return pairs.get(0) * 2;
        }
    }

    public static int twoPair(DiceRoll diceRoll) {
        List<Integer> pairs = diceRoll.findPairs();
        if (pairs.size() >= 2) {
            return pairs.stream()
                .mapToInt(pair -> pair * 2)
                .sum();
        }
        return 0;
    }

    public static int threeOfAKind(DiceRoll diceRoll) {
        return diceRoll.getDiceWithCountGreaterThan(3) * 3;
    }

    public static int fourOfAKind(DiceRoll diceRoll) {
        return diceRoll.getDiceWithCountGreaterThan(4) * 4;
    }

    public static int smallStraight(DiceRoll diceRoll) {
        if (diceRoll.isSmallStraight()) {
            return 15;
        }
        return 0;
    }

    public static int largeStraight(DiceRoll diceRoll) {
        if (diceRoll.isLargeStraight()) {
            return 20;
        }
        return 0;
    }

    public static int fullHouse(DiceRoll diceRoll) {
        if (diceRoll.isFullHouse()) {
            return diceRoll.sum();
        }
        return 0;
    }


}
