package racingcar.domain;

import racingcar.service.RandomService;

public class RandomNumberGenerator {

    private final RandomService randomService;

    public RandomNumberGenerator(RandomService randomService) {
        this.randomService = randomService;
    }

    public int createRandomNumber(int startInclusive, int endInclusive) {
        return randomService.pickNumberInRange(startInclusive, endInclusive);
    }
}
