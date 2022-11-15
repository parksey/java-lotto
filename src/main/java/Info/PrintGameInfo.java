package Info;

import lotto.Lotto;
import lotto.LottoList;

import java.math.BigInteger;
import java.util.List;

public class PrintGameInfo {
    public static final char ZERO = '0';
    public static final String ERROR = "[ERROR] ";
    public static final String OPEN_SQUARE_BRACKETS = "[";
    public static final String CLOSE_SQUARE_BRACKETS = "]";
    public static final String IS_NOT_DIGIT_STRING = "숫자 이외의 값이 존재합니다.";
    public static final String IS_EMPTY_STRING = "아무 값도 입력하지 않았습니다.";
    public static final String NOT_DIVDE_THOUSAND = "최소단위"+Integer.toString(LottoList.AMOUNT_UNIT)+"로 나눠지지 않습니다.";
    public static final String USER_INPUT_ZERO = "0원으로는 하나도 살 수 없습니다.";
    public static final String PURCHASE_COUNT = "개를 구매했습니다.";

    public static final String OVER_LOTTO_COUNT = "선택가능한 로또 숫자 갯수를 넘겼습니다.";
    public static final String OUT_OF_RANGE = "로또 숫자의 범위 밖의 숫자를 선택하였습니다.";

    public static void purchaseAmountInfo() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    public static void winningNumberInfo() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
    public static void bonnusNumberInfo() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void purchaseCount(BigInteger count) {
        System.out.println(count+PURCHASE_COUNT);
    }

    public static void lottoInfoList(LottoList lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            String lottoNumbers = lotto.numbersToString();
            System.out.println(OPEN_SQUARE_BRACKETS+lottoNumbers+CLOSE_SQUARE_BRACKETS);
        }
    }

    public static String getIsNotDigitString() {
        return ERROR + IS_NOT_DIGIT_STRING;
    }
    public static String getIsEmptyString() {
        return ERROR + IS_EMPTY_STRING;
    }

    public static String getNotDivThousand() {
        return ERROR + NOT_DIVDE_THOUSAND;
    }

    public static String getUserInputZero() {
        return ERROR + USER_INPUT_ZERO;
    }

    public static String getOutOfRange() {
        return ERROR + OUT_OF_RANGE;
    }
}
