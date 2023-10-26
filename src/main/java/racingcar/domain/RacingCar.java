package racingcar.domain;

import java.util.Objects;

public class RacingCar {
    protected static final String CAR_NAME_LENGTH_OVER_FIVE_EXCEPTION = "자동차 이름은 5자가 넘을 수 없습니다!";
    private final String name;

    public RacingCar(String name) {
        if (name.length() <= 5) {
            this.name = name;
            return;
        }
        throw new IllegalArgumentException(CAR_NAME_LENGTH_OVER_FIVE_EXCEPTION);
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
        return Objects.equals(name, racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
