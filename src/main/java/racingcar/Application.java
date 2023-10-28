package racingcar;

import java.util.List;
import racingcar.controller.RacingGameController;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomNumberGenerator;
import racingcar.dto.RacingCarDto;
import racingcar.dto.RacingGameRq;
import racingcar.dto.RacingGameRs;
import racingcar.service.DefaultConsoleService;
import racingcar.service.DefaultRandomService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView(new DefaultConsoleService());
        OutputView outputView = new OutputView();
        RacingGameController controller = new RacingGameController(
                new RacingGame(new RandomNumberGenerator(new DefaultRandomService())));

        List<String> carNames = inputView.inputCarNames();
        long numberOfAttempts = inputView.inputNumberOfAttempts();

        RacingGameRq racingGameRq = createGameRequest(carNames, numberOfAttempts);
        outputView.printExecutionResultMent();

        racingGameRq = createWinnerDto(controller, racingGameRq, outputView, numberOfAttempts);
        outputView.printWinners(racingGameRq.getRacingCarDtoList());
    }

    private static RacingGameRq createWinnerDto(RacingGameController controller, RacingGameRq racingGameRq,
                                                OutputView outputView, long numberOfAttempts) {
        do {
            RacingGameRs racingGameRs = controller.startGame(racingGameRq);
            outputView.printExecutionResult(racingGameRq.getRacingCarDtoList());
            racingGameRq = createNextGameRequest(racingGameRs);
        } while (numberOfAttempts-- > 0);
        return racingGameRq;
    }

    private static RacingGameRq createGameRequest(List<String> carNames, long numberOfAttempts) {
        List<RacingCarDto> racingCarDtos = carNames.stream().map(carName -> new RacingCarDto(carName, 0)).toList();
        return RacingGameRq.valueOf(racingCarDtos, numberOfAttempts);
    }

    private static RacingGameRq createNextGameRequest(RacingGameRs racingGameRs) {
        return RacingGameRq.valueOf(racingGameRs.getRacingCarDtoList(), racingGameRs.getLeftNumberOfAttempts());
    }
}
