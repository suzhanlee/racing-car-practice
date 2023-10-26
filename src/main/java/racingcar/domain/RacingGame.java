package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.GameStartRq;
import racingcar.dto.GameStartRs;
import racingcar.dto.RacingCarDto;

public class RacingGame {

    private final RandomNumberGenerator randomNumberGenerator;

    public RacingGame(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public List<GameStartRs> startGame(GameStartRq rq) {
        List<GameStartRs> rs = new ArrayList<>();
        rq.getRacingCarDtos().stream()
                .map(racingCarDto -> new RacingCar(racingCarDto.getCarName(), racingCarDto.getPosition(),
                        new MoveCondition()))
                .forEachOrdered(racingCar -> {
                    int randomNumber = randomNumberGenerator.createRandomNumber(0, 9);
                    racingCar.race(randomNumber);
                    rs.add(GameStartRs.createGameStartRs(racingCar));
                });
        return rs;
    }
}
