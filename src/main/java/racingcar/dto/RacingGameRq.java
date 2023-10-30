package racingcar.dto;

import java.util.List;
import racingcar.domain.RacingCar;

public class RacingGameRq {

    private List<RacingCarDto> racingCarDtoList;
    private long leftNumberOfAttempts;

    private RacingGameRq(List<RacingCarDto> racingCarDtoList, long leftNumberOfAttempts) {
        this.racingCarDtoList = racingCarDtoList;
        this.leftNumberOfAttempts = leftNumberOfAttempts;
    }

    public static RacingGameRq valueOf(List<RacingCarDto> racingCarDtoList, long leftNumberOfAttempts) {
        return new RacingGameRq(racingCarDtoList, leftNumberOfAttempts);
    }

    public List<RacingCarDto> getRacingCarDtoList() {
        return racingCarDtoList;
    }

    public long getLeftNumberOfAttempts() {
        return leftNumberOfAttempts;
    }

    public List<RacingCar> toRacingCars() {
        return getRacingCarDtoList().stream()
                .map(RacingCarDto::toRacingCar).toList();
    }
}
