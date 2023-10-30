package racingcar.domain;

import racingcar.service.RandomService;

public class RandomNumberFactory {

    private final RandomService randomService;

    public RandomNumberFactory(RandomService randomService) {
        this.randomService = randomService;
    }

    public int createRandomNumber(int startInclusive, int endInclusive) {
        return randomService.pickNumberInRange(startInclusive, endInclusive);
    }
}
