package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomNumberGenerator;
import racingcar.service.DefaultConsoleService;
import racingcar.service.DefaultRandomService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView(new DefaultConsoleService());
        OutputView outputView = new OutputView();
        RacingGameController controller = new RacingGameController(inputView, outputView,
                new RacingGame(new RandomNumberGenerator(new DefaultRandomService())));

        controller.startGame();
    }
}
