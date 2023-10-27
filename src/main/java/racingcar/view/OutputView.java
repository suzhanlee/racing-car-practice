package racingcar.view;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.dto.GameStartRs;

public class OutputView {

    private static final String EXECUTION_RESULT_MENT = "실행 결과";
    private static final String WINNER_NAMES = "최종 우승자 : ";

    public void printExecutionResultMent() {
        System.out.println(EXECUTION_RESULT_MENT);
    }

    public void printExecutionResult(List<GameStartRs> rs) {
        StringBuilder executionResultStorage = new StringBuilder();
        rs.forEach(dto -> {
            executionResultStorage.append(dto.getCarName()).append(" : ");
            executionResultStorage.append("-".repeat(Math.max(0, dto.getPosition())));
        });
        System.out.println(executionResultStorage);
    }

    public void printWinners(List<String> winnerNames) {
        StringBuilder winnerNameStorage = new StringBuilder();
        IntStream.range(0, winnerNames.size()).forEachOrdered(winnerIndex -> {
            String winnerName = winnerNames.get(winnerIndex);
            if (winnerIndex == 0) {
                winnerNameStorage.append(winnerName);
                return;
            }
            winnerNameStorage.append(", ").append(winnerName);
        });
        System.out.println(WINNER_NAMES + winnerNameStorage);
    }
}
