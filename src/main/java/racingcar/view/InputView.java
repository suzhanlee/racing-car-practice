package racingcar.view;

import java.util.Arrays;
import java.util.List;
import racingcar.service.ConsoleService;

public class InputView {

    private final ConsoleService consoleService;

    public InputView(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    public List<String> inputCarNames() {
        return List.of(consoleService.readLine().split(","));
    }
}
