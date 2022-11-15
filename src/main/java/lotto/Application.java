package lotto;

import Info.InputException;
import Info.PrintGameInfo;
import camp.nextstep.edu.missionutils.Console;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static final String COMMA = ",";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PrintGameInfo.purchaseAmountInfo();

        try {
            String amount = inputAmount();
            LottoList userLotto = new LottoList(new BigInteger(amount));

            PrintGameInfo.purchaseCount(userLotto.getLottoCount());
            PrintGameInfo.lottoInfoList(userLotto);

            PrintGameInfo.winningNumberInfo();
            userLotto.setWinningLotto(inputLottoWinningNumbers());

            PrintGameInfo.bonnusNumberInfo();
            userLotto.setBonnusNumber(inputBonnusNumber());

        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }

    }
    public static String inputAmount() {
        String amount = Console.readLine();
        InputException.emptyException(amount);
        InputException.outOfDigitException(amount);
        return amount;
    }

    public static Lotto inputLottoWinningNumbers() {
        String userInput = Console.readLine();
        InputException.wrongWinningNumberFormat(userInput);

        List<String> winningNumber = Arrays.asList(userInput.split(COMMA));
        return Lotto.stringListToLotto(winningNumber);
    }

    public static int inputBonnusNumber() {
        String userInput = Console.readLine();
        InputException.emptyException(userInput);
        InputException.outOfDigitException(userInput);

        int bonnusNumber = Integer.valueOf(userInput);
        Lotto.isOutOfRange(bonnusNumber);
        return bonnusNumber;
    }
}
