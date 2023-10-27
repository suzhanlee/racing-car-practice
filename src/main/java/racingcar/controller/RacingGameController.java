package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.dto.GameStartRq;
import racingcar.dto.GameStartRs;
import racingcar.dto.RacingCarDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGame racingGame;

    public RacingGameController(InputView inputView, OutputView outputView, RacingGame racingGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingGame = racingGame;
    }

    public void startGame() {

        List<String> carNames = inputView.inputCarNames();
        long numberOfAttempts = inputView.inputNumberOfAttempts();

        GameStartRq firstRequest = new GameStartRq(new ArrayList<>());

        for (String carName : carNames) {
            firstRequest.getRacingCarDtos().add(new RacingCarDto(carName, 0));
        }

        outputView.printExecutionResultMent();
        List<GameStartRs> gameResult = racingGame.startGame(firstRequest);
        outputView.printExecutionResult(gameResult);

        do {
            GameStartRq nextRequest = new GameStartRq(new ArrayList<>());
            for (GameStartRs rs : gameResult) {
                RacingCarDto racingCarDto = new RacingCarDto(rs.getCarName(), rs.getPosition());
                nextRequest.getRacingCarDtos().add(racingCarDto);
            }
            gameResult = racingGame.startGame(nextRequest);
        } while (numberOfAttempts-- > 0);

        outputView.printWinners(gameResult);
    }
}
