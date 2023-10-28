package racingcar.dto;

import racingcar.domain.RacingCar;

public class RacingCarDto {

    private String carName;
    private int position;

    public RacingCarDto(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }


    public static RacingCarDto createRacingCarDto(RacingCar racingCar) {
        return new RacingCarDto(racingCar.getName(), racingCar.getPosition());
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
