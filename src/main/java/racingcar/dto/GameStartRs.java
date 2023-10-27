package racingcar.dto;

import java.util.List;
import racingcar.domain.RacingCar;

public class GameStartRs {
    private String carName;
    private int position;

    private GameStartRs() {}

    public static GameStartRs createGameStartRs(RacingCar racingCar) {
        GameStartRs rs = new GameStartRs();
        rs.carName = racingCar.getName();
        rs.position = racingCar.getPosition();
        return rs;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
