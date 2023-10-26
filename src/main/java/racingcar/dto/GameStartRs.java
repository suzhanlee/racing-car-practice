package racingcar.dto;

import java.util.List;

public class GameStartRs {
    private String carName;
    private int position;

    public GameStartRs(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }
}
