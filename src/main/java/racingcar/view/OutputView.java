package racingcar.view;

import java.util.List;
import racingcar.dto.RacingCarDto;

public class OutputView {

    private static final String EXECUTION_RESULT_MENT = "실행 결과";
    private static final String WINNER_NAMES = "최종 우승자 : ";

    public void printExecutionResultMent() {
        System.out.println(EXECUTION_RESULT_MENT);
    }

    public void printExecutionResult(List<RacingCarDto> executionResult) {
        StringBuilder executionResultStorage = new StringBuilder();
        executionResult.forEach(dto -> {
            executionResultStorage.append(dto.getCarName()).append(" : ");
            executionResultStorage.append("-".repeat(Math.max(0, dto.getPosition()))).append('\n');
        });
        System.out.println(executionResultStorage);
    }

    public void printWinners(List<RacingCarDto> racingCarDtos) {
        int max = findFinishLine(racingCarDtos);

        StringBuilder winnerNameStorage = new StringBuilder();

        List<String> winnerNames = racingCarDtos.stream().filter(racingCarDto -> racingCarDto.getPosition() == max)
                .map(RacingCarDto::getCarName).toList();

        storeWinnerInStorage(winnerNames.get(0), winnerNameStorage);

        if (existsJointWinner(winnerNames)) {
            storeJointWinnerInStorage(winnerNames, winnerNameStorage);
        }

        System.out.println(WINNER_NAMES + winnerNameStorage);
    }

    private int findFinishLine(List<RacingCarDto> racingCarDtos) {
        int max = 0;
        for (RacingCarDto racingCarDto : racingCarDtos) {
            max = Math.max(racingCarDto.getPosition(), max);
        }
        return max;
    }

    private boolean existsJointWinner(List<String> winnerNames) {
        return winnerNames.size() >= 2;
    }

    private void storeWinnerInStorage(String winnerName, StringBuilder winnerNameStorage) {
        winnerNameStorage.append(winnerName);
    }

    private void storeJointWinnerInStorage(List<String> winnerNames, StringBuilder winnerNameStorage) {
        for (int winnerIndex = 1; winnerIndex < winnerNames.size(); winnerIndex++) {
            winnerNameStorage.append(", ").append(winnerNames.get(winnerIndex));
        }
    }
}
