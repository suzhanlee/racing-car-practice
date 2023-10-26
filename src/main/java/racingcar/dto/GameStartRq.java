package racingcar.dto;

import java.util.List;

public class GameStartRq {
    private List<RacingCarDto> racingCarDtos;

    public GameStartRq(List<RacingCarDto> racingCarDtos) {
        this.racingCarDtos = racingCarDtos;
    }

    public List<RacingCarDto> getRacingCarDtos() {
        return racingCarDtos;
    }
}
