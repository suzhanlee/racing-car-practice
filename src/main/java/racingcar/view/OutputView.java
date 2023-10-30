package racingcar.view;

import java.util.List;
import java.util.StringJoiner;
import racingcar.dto.RacingCarDto;

public class OutputView {

    private static final String EXECUTION_RESULT_MENT = "실행 결과";
    private static final String WINNER_NAMES = "최종 우승자 : ";

    public void printExecutionResultMent() {
        System.out.println(EXECUTION_RESULT_MENT);
    }

    public void printExecutionResult(List<RacingCarDto> executionResult) {
        System.out.println(renderResult(executionResult));
    }

    private String renderResult(List<RacingCarDto> executionResult) {
        StringBuilder renderer = new StringBuilder();
        executionResult.forEach(result -> {
            renderer.append(result.getCarName()).append(" : ");
            renderer.append("-".repeat(Math.max(0, result.getPosition()))).append('\n');
        });
        return renderer.toString();
    }

    public void printWinners(List<RacingCarDto> racingCarDtos) {

        List<RacingCarDto> winnerDtos = getWinnerDtos(racingCarDtos);

        List<String> winnerNames = createWinnerNames(winnerDtos);

        System.out.println(WINNER_NAMES + renderWinner(winnerNames));
    }

    private String renderWinner(List<String> winnerNames) {
        StringJoiner renderer = new StringJoiner(", ");
        winnerNames.forEach(renderer::add);
        return renderer.toString();
    }

    private List<RacingCarDto> getWinnerDtos(List<RacingCarDto> racingCarDtos) {
        int finishLine = findFinishLine(racingCarDtos);
        return racingCarDtos.stream().filter(racingCarDto -> racingCarDto.getPosition() == finishLine).toList();
    }

    private List<String> createWinnerNames(List<RacingCarDto> racingCarDtos) {
        return racingCarDtos.stream().map(RacingCarDto::getCarName).toList();
    }

    private int findFinishLine(List<RacingCarDto> racingCarDtos) {
        int finishLine = 0;
        for (RacingCarDto racingCarDto : racingCarDtos) {
            finishLine = Math.max(racingCarDto.getPosition(), finishLine);
        }
        return finishLine;
    }
}
