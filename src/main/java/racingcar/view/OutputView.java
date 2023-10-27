package racingcar.view;

import java.util.List;
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
            executionResultStorage.append("-".repeat(Math.max(0, dto.getPosition()))).append('\n');
        });
        System.out.println(executionResultStorage);
    }

    public void printWinners(List<GameStartRs> gameResults) {
        int max = findFinishLine(gameResults);

        StringBuilder winnerNameStorage = new StringBuilder();
        storeWinnerInStorage(gameResults, winnerNameStorage);

        if (existsJointWinner(gameResults)) {
            storeJointWinnerInStorage(gameResults, winnerNameStorage, max);
        }

        System.out.println(WINNER_NAMES + winnerNameStorage);
    }

    private int findFinishLine(List<GameStartRs> gameResults) {
        int max = 0;
        for (GameStartRs gameResult : gameResults) {
            max = Math.max(gameResult.getPosition(), max);
        }
        return max;
    }

    private boolean existsJointWinner(List<GameStartRs> gameResults) {
        return gameResults.size() >= 2;
    }

    private void storeWinnerInStorage(List<GameStartRs> gameResults, StringBuilder winnerNameStorage) {
        winnerNameStorage.append(gameResults.get(0).getCarName());
    }

    private void storeJointWinnerInStorage(List<GameStartRs> gameResults, StringBuilder winnerNameStorage, int max) {
        for (int i = 1; i < gameResults.size(); i++) {
            String winnerName = gameResults.get(i).getCarName();
            if (gameResults.get(i).isFinishLine(max)) {
                winnerNameStorage.append(", ").append(winnerName);
            }
        }
    }
}
