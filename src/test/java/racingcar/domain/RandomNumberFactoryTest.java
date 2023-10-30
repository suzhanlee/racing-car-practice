package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.service.DoubleRandomService;

public class RandomNumberFactoryTest {

    @ParameterizedTest
    @DisplayName("0 ~ 9 사이의 랜덤 값을 만든다.")
    @ValueSource(ints = {0, 9})
    void createRandomNumberRangeZeroToNine(int given) {
        // given
        RandomNumberFactory generator = new RandomNumberFactory(new DoubleRandomService(given));

        // when
        int result = generator.createRandomNumber(0, 9);

        // then
        assertThat(result).isEqualTo(given);
    }
}
