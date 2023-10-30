package racingcar.domain;

public class MoveCondition {
    public static final int START_MOVE_NUMBER = 4;
    public static final int END_MOVE_NUMBER = 9;

    public boolean check(int number) {
        return number >= START_MOVE_NUMBER && number <= END_MOVE_NUMBER;
    }
}
