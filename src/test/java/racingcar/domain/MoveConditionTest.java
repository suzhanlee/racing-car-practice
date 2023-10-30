package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoveConditionTest {

    @ParameterizedTest
    @DisplayName("0에서 9 사이의 값을 받아 값이 4 이상 경우 true 반환")
    @ValueSource(ints = {4, 9})
    void move(int given) {
        // given
        MoveCondition condition = new MoveCondition();

        // when
        boolean result = condition.check(given);

        // then
        assertThat(result).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("0에서 9 사이의 값을 받아 값이 4 미만인 경우 false 반환")
    @ValueSource(ints = {0, 3})
    void cannotMove(int given) {
        // given
        MoveCondition condition = new MoveCondition();

        // when
        boolean result = condition.check(given);

        // then
        assertThat(result).isEqualTo(false);
    }
}
