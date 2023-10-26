package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.GameStartRq;
import racingcar.dto.GameStartRs;
import racingcar.dto.RacingCarDto;
import racingcar.service.DoubleRandomService;

class RacingGameTest {

    @Test
    @DisplayName("GameStartRq를 활용해 레이싱 카들의 이름과 위치를 가져온다.")
    void startGame() {
        // given
        List<RacingCarDto> racingCarDtos
                = new ArrayList<>(List.of(
                        new RacingCarDto("chan", 0),
                        new RacingCarDto("tobi", 1),
                        new RacingCarDto("ship", 2)));

        GameStartRq rq = new GameStartRq(racingCarDtos);
        RacingGame racingGame = new RacingGame(new RandomNumberGenerator(new DoubleRandomService(4)));

        // when
        List<GameStartRs> result = racingGame.startGame(rq);

        // then
        assertThat(result).hasSize(3)
                .extracting("carName", "position")
                .containsExactlyInAnyOrder(
                        tuple("chan", 1),
                        tuple("tobi", 2),
                        tuple("ship", 3)
                );
    }
}