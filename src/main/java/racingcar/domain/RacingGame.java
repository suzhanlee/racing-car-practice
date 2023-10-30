package racingcar.domain;

import java.util.List;
import racingcar.dto.RacingGameRq;
import racingcar.dto.RacingGameRs;

public class RacingGame {

    public static final int ATTEMPT_NUMBER = 1;
    private final RandomNumberFactory randomNumberFactory;

    public RacingGame(RandomNumberFactory randomNumberFactory) {
        this.randomNumberFactory = randomNumberFactory;
    }

    public RacingGameRs startGame(RacingGameRq racingGameRq) {
        List<RacingCar> racingCars = racingGameRq.toRacingCars();
        move(racingCars);
        return RacingGameRs.createRacingGameRs(racingCars, leftNumberOfAttempts(racingGameRq));
    }

    private void move(List<RacingCar> cars) {
        cars.forEach(racingCar -> {
            racingCar.race(randomNumberFactory.createRandomNumber(0, 9));
        });
    }

    private long leftNumberOfAttempts(RacingGameRq racingGameRq) {
        return racingGameRq.getLeftNumberOfAttempts() - ATTEMPT_NUMBER;
    }
}
