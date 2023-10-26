package racingcar.view;

import java.util.Arrays;
import java.util.List;
import racingcar.service.ConsoleService;

public class InputView {

    protected static final String NUMBER_OF_ATTEMPTS_ONLY_ALLOW_NUMBER_EXCEPTION = "시도 횟수는 숫자만 입력할 수 있습니다.";
    private final ConsoleService consoleService;

    public InputView(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    public List<String> inputCarNames() {
        return List.of(consoleService.readLine().split(","));
    }

    public long inputNumberOfAttempts() {
        try {
            return Long.parseLong(consoleService.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_OF_ATTEMPTS_ONLY_ALLOW_NUMBER_EXCEPTION);
        }
    }
}
