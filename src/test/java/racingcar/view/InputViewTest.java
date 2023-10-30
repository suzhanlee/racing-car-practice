package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.view.InputView.NUMBER_OF_ATTEMPTS_ONLY_ALLOW_NUMBER_EXCEPTION;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.service.DoubleConsoleService;

public class InputViewTest {

    @Test
    @DisplayName("경주할 자동차 이름들을 쉼표로 구분하며 입력할 수 있다.")
    void inputCarNames() {
        // given
        InputView inputView = new InputView(new DoubleConsoleService("tobi,ship,chan"));

        // when
        List<String> carNames = inputView.carNames();

        // then
        assertThat(carNames).isEqualTo(List.of("tobi", "ship", "chan"));
    }

    @Test
    @DisplayName("경주를 시도할 횟수를 입력할 수 있다.")
    void inputNumberOfAttempts() {
        // given
        InputView inputView = new InputView(new DoubleConsoleService("12"));

        // when
        long numberOfAttempts = inputView.numberOfAttempts();

        // then
        Assertions.assertThat(numberOfAttempts).isEqualTo(12);
    }

    @ParameterizedTest
    @DisplayName("시도할 횟수에는 숫자만 입력할 수 있습니다.")
    @ValueSource(strings = {"1@", "2d424", "가나"})
    void inputErrorWithNumberOfAttempts(String given) {
        // given
        InputView inputView = new InputView(new DoubleConsoleService(given));

        // when // then
        assertThatThrownBy(inputView::numberOfAttempts)
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBER_OF_ATTEMPTS_ONLY_ALLOW_NUMBER_EXCEPTION);
    }
}
