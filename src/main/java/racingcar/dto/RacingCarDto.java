package racingcar.dto;

import racingcar.domain.MoveCondition;
import racingcar.domain.RacingCar;

public class RacingCarDto {

    private String carName;
    private int position;

    public RacingCarDto(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public static RacingCarDto createRacingCarDto(RacingCar racingCar) {
        return new RacingCarDto(racingCar.name(), racingCar.position());
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public RacingCar toRacingCar() {
        return new RacingCar(this.carName, this.position, new MoveCondition());
    }
}
