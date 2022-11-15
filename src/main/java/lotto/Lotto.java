package lotto;

import Info.PrintGameInfo;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_MAX_NUMBER = 45; // 로또 최대 숫자
    public static final int LOTTO_MIN_NUMBER = 1; // 로또 최소 숫자
    public static final int LOTTO_NUMBER_COUNT = 6; // 로또 숫자 갯수
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        outOfRangeExceptioin(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(PrintGameInfo.OVER_LOTTO_COUNT);
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void outOfRangeExceptioin(List<Integer> numbers) {
        for(Integer number : numbers) {
            if(isOutOfRange(number)) {
                throw new IllegalArgumentException(PrintGameInfo.getOutOfRange());
            }
        }
    }

    private static boolean isOutOfRange(Integer number) {
        return number > LOTTO_MAX_NUMBER || number < LOTTO_MIN_NUMBER;
    }

    public String numbersToString() {
        List<String> numberList = getStringNumbers();
        return String.join(", ", numberList);
    }

    private List<String> getStringNumbers() {
        return numbers.stream().map(String::valueOf).collect(Collectors.toList());
    }
}
