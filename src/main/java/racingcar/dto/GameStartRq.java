package racingcar.dto;

import java.util.List;
import java.util.stream.Collectors;

public class GameStartRq {
    private List<RacingCarDto> racingCarDtos;

    public GameStartRq(List<RacingCarDto> racingCarDtos) {
        this.racingCarDtos = racingCarDtos;
    }

    public List<RacingCarDto> getRacingCarDtos() {
        return racingCarDtos;
    }

    public static GameStartRq createGameStartRqWithCarNames(List<String> carNames) {

        return new GameStartRq(
                carNames.stream().map(
                        carName -> new RacingCarDto(carName, 0)
                ).collect(Collectors.toList()));
    }
}
