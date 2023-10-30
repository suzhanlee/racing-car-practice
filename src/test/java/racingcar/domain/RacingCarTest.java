package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.RacingCar.CAR_NAME_LENGTH_OVER_FIVE_EXCEPTION;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.service.DoubleRandomService;

public class RacingCarTest {

    @ParameterizedTest
    @DisplayName("5자 이하의 자동차 이름을 사용해 경주차를 만들 수 있다.")
    @ValueSource(strings = {"suz", "&(&(", "chan"})
    void createRacingCarWithLessThanFiveName(String given) {
        // given
        MoveCondition moveCondition = new MoveCondition();

        // when
        RacingCar racingCar = new RacingCar(given, moveCondition);

        // then
        assertThat(racingCar).isEqualTo(new RacingCar(given, moveCondition));
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 5자라 넘으면 예외가 발생한다.")
    @ValueSource(strings = {"suzhan", "&(&(12", "chanlee"})
    void createRacingCarError(String given) {
        // given
        MoveCondition moveCondition = new MoveCondition();

        // when //then
        assertThatThrownBy(() -> new RacingCar(given, moveCondition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_LENGTH_OVER_FIVE_EXCEPTION);
    }

    @ParameterizedTest
    @DisplayName("경주를 해 랜덤 값이 4 이상이면 레이싱 카는 한칸 앞으로 간다.")
    @ValueSource(ints = {4, 9})
    void goOneStepForward(int given) {
        // given
        MoveCondition moveCondition = new MoveCondition();
        RacingCar racingCar = new RacingCar("tobi", moveCondition);
        RandomNumberFactory randomNumberFactory = new RandomNumberFactory(new DoubleRandomService(given));
        int randomNumber = randomNumberFactory.createRandomNumber(0, 9);

        // when
        racingCar.race(randomNumber);

        // then
        assertThat(racingCar).isEqualTo(new RacingCar("tobi", 1, moveCondition));
    }

    @ParameterizedTest
    @DisplayName("경주를 해 랜덤 값이 4 미만이면 레이싱 카는 움직이지 않는다.")
    @ValueSource(ints = {0, 3})
    void cannotGoOneStepForward(int given) {
        // given
        MoveCondition moveCondition = new MoveCondition();
        RacingCar racingCar = new RacingCar("tobi", moveCondition);
        RandomNumberFactory randomNumberFactory = new RandomNumberFactory(new DoubleRandomService(given));
        int randomNumber = randomNumberFactory.createRandomNumber(0, 9);

        // when
        racingCar.race(randomNumber);

        // then
        assertThat(racingCar).isEqualTo(new RacingCar("tobi", moveCondition));
    }
}
