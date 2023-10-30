package racingcar;

import java.util.List;
import racingcar.config.ObjectFactory;
import racingcar.controller.RacingGameController;
import racingcar.dto.RacingCarDto;
import racingcar.dto.RacingGameRq;
import racingcar.dto.RacingGameRs;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ObjectFactory objectFactory = new ObjectFactory();
        InputView inputView = objectFactory.inputView();
        OutputView outputView = objectFactory.outPutView();
        RacingGameController controller = objectFactory.controller();

        List<String> carNames = inputView.carNames();
        long numberOfAttempts = inputView.numberOfAttempts();

        RacingGameRq racingGameRq = createGameRequest(carNames, numberOfAttempts);
        outputView.printExecutionResultMent();

        // 여기서 do while 문 안의 OutputView 는 한번에 view를 출력해 밖으로 뺄 수 있다.
        // 그러면, do-while문을 메소드 추출할 수 있어져 의미가 명확해짐!
        while (numberOfAttempts-- > 0) {
            RacingGameRs racingGameRs = controller.startGame(racingGameRq);
            outputView.printExecutionResult(racingGameRs.getRacingCarDtoList());
            racingGameRq = createNextGameRequest(racingGameRs);
        }

        outputView.printWinners(racingGameRq.getRacingCarDtoList());
    }

    private static RacingGameRq createGameRequest(List<String> carNames, long numberOfAttempts) {
        List<RacingCarDto> racingCarDtos = carNames.stream().map(carName -> new RacingCarDto(carName, 0)).toList();
        return RacingGameRq.valueOf(racingCarDtos, numberOfAttempts);
    }

    private static RacingGameRq createNextGameRequest(RacingGameRs racingGameRs) {
        return RacingGameRq.valueOf(racingGameRs.getRacingCarDtoList(), racingGameRs.getLeftNumberOfAttempts());
    }
}
