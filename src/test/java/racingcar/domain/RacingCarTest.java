package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.RacingCar.CAR_NAME_LENGTH_OVER_FIVE_EXCEPTION;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarTest {

    @ParameterizedTest
    @DisplayName("5자 이하의 자동차 이름을 사용해 경주차를 만들 수 있다.")
    @ValueSource(strings = {"suz", "&(&(", "chan"})
    void createRacingCarWithLessThanFiveName(String given) {
        // when
        RacingCar racingCar = new RacingCar(given);

        // then
        assertThat(racingCar).isEqualTo(new RacingCar(given));
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 5자라 넘으면 예외가 발생한다.")
    @ValueSource(strings = {"suzhan", "&(&(12", "chanlee"})
    void createRacingCarError(String given) {
        // when //then
        assertThatThrownBy(() -> new RacingCar(given))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_LENGTH_OVER_FIVE_EXCEPTION);
    }
}
