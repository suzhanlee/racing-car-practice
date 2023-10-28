package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.RacingGameRq;
import racingcar.dto.RacingGameRs;

public class RacingGame {

    public static final int ATTEMPT_NUMBER = 1;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingGame(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public RacingGameRs startGame(RacingGameRq racingGameRq) {
        List<RacingCar> racingCars = new ArrayList<>();
        racingGameRq.getRacingCarDtoList().stream()
                .map(racingCarDto -> new RacingCar(racingCarDto.getCarName(), racingCarDto.getPosition(),
                        new MoveCondition())).forEachOrdered(racingCar -> {
                    racingCar.race(randomNumberGenerator.createRandomNumber(0, 9));
                    racingCars.add(racingCar);
                });
        return RacingGameRs.createRacingGameRs(racingCars, findLeftNumberOfAttempts(racingGameRq));
    }

    private long findLeftNumberOfAttempts(RacingGameRq racingGameRq) {
        return racingGameRq.getLeftNumberOfAttempts() - ATTEMPT_NUMBER;
    }
}
