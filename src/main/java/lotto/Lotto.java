package lotto;

import Info.InputException;
import Info.PrintGameInfo;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_MAX_NUMBER = 45; // 로또 최대 숫자
    public static final int LOTTO_MIN_NUMBER = 1; // 로또 최소 숫자
    public static final int LOTTO_NUMBER_COUNT = 6; // 로또 숫자 갯수
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        outOfRangeExceptioin(numbers);
        checkNoDuplicateWinnningLotto(numbers);
        List<Integer> numbersCopy = deepCopy(numbers);
        this.numbers = numbersCopy;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(PrintGameInfo.getOverLottoCount());
        }
    }

    // TODO: 추가 기능 구현
    public static void isOutOfRangeException(Integer number) {
        if (number > LOTTO_MAX_NUMBER || number < LOTTO_MIN_NUMBER) {
            throw new IllegalArgumentException(PrintGameInfo.getOutOfRange());
        }
    }

    /**
     * 로또 당첨 번호 자체 중복 여부 확인
     * @param numbers
     */
    private void checkNoDuplicateWinnningLotto(List<Integer> numbers) {
        Set<Integer> checkList = new HashSet<>(numbers);
        if (checkList.size() != numbers.size()) {
            throw new IllegalArgumentException(PrintGameInfo.getDuplicate());
        }
    }

    /**
     * Random Test환경에서 실행시 UnsupportedOperationError가 났다
     * 따라서 Test값을 따로 넘겨줘서 정렬하고 사용
     * @param numbers
     * @return
     */
    public List<Integer> deepCopy(List<Integer> numbers) {
        List<Integer> numbersCopy = new ArrayList<>();
        for (Integer number : numbers) {
            numbersCopy.add(number);
        }
        numbersCopy.sort(Comparator.naturalOrder());
        return numbersCopy;
    }

    public static List<Integer> getIntNumbers(List<String> userInput) {
        return userInput.stream().map(Integer::valueOf).collect(Collectors.toList());
    }

    /**
     * 사용자 입력에 대해 로또 클래스로 반환해주는 함수
     * @param userInput
     * @return
     */
    public static Lotto stringListToLotto(List<String> userInput) {
        return new Lotto(getIntNumbers(userInput));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void outOfRangeExceptioin(List<Integer> numbers) {
        for (Integer number : numbers) {
            isOutOfRangeException(number);
        }
    }

    public String numbersToString() {
        List<String> numberList = getStringNumbers();
        return String.join(", ", numberList);
    }

    private List<String> getStringNumbers() {
        return numbers.stream().map(String::valueOf).collect(Collectors.toList());
    }


}
