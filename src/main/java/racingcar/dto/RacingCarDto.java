package racingcar.dto;

public class RacingCarDto {

    private String carName;
    private int position;

    public RacingCarDto(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
