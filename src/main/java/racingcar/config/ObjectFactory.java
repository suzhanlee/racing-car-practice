package racingcar.config;

import racingcar.controller.RacingGameController;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomNumberFactory;
import racingcar.service.DefaultConsoleService;
import racingcar.service.DefaultRandomService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class ObjectFactory {

    public InputView inputView() {
        return new InputView(new DefaultConsoleService());
    }

    public OutputView outPutView() {
        return new OutputView();
    }

    public RacingGameController controller() {
        return new RacingGameController(
                new RacingGame(new RandomNumberFactory(new DefaultRandomService())));
    }
}
