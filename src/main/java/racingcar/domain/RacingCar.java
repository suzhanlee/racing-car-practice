package racingcar.domain;

import java.util.Objects;

public class RacingCar {
    protected static final String CAR_NAME_LENGTH_OVER_FIVE_EXCEPTION = "자동차 이름은 5자가 넘을 수 없습니다!";
    private final String name;
    private int position;
    private final MoveCondition moveCondition;

    public RacingCar(String name, MoveCondition moveCondition) {
        if (name.length() <= 5) {
            this.moveCondition = moveCondition;
            this.name = name;
            this.position = 0;
            return;
        }
        throw new IllegalArgumentException(CAR_NAME_LENGTH_OVER_FIVE_EXCEPTION);
    }

    public int race(int randomNumber) {
        boolean canGoOneStepForward = moveCondition.checkNumber(randomNumber);
        if (canGoOneStepForward) {
            this.position++;
        }
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingCar racingCar = (RacingCar) o;
        return position == racingCar.position && Objects.equals(name, racingCar.name) && Objects.equals(
                moveCondition, racingCar.moveCondition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position, moveCondition);
    }
}
