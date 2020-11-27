package baseball.function;

import java.util.stream.Stream;

public class Validator {

    private static final String ZERO = "0";
    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String PLEASE_INPUT_THREE_DIGIT_NUMBER = "3자리 숫자를 입력해주세요.";
    private static final String PLEASE_INPUT_ONE_DIGIT_NUMBER = "1자리 숫자를 입력해주세요.";
    private static final String PLEASE_INPUT_NON_ZERO_NUMBER = "0이 포함되지 않는 3자리 숫자를 입력해주세요.";
    private static final String PLEASE_INPUT_1_OR_2 = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String PLEASE_INPUT_ALL_DIFFERENT_NUMBER = "서로 다른 수의 3자리 숫자를 입력해주세요.";
    private static final int MIN = 0;
    private static final int USER_NUMBER_LENGTH = 3;

    private Validator() {}

    public static boolean isNaturalNumberForuserNumber(String userNumber) {
        try {
            Integer.parseInt(userNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(PLEASE_INPUT_THREE_DIGIT_NUMBER);
            return false;
        }
        return true;
    }


    public static boolean isNaturalNumberForRestartNumber(String userNumber) {
        try {
            Integer.parseInt(userNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(PLEASE_INPUT_ONE_DIGIT_NUMBER);
            return false;
        }
        return true;
    }

    public static boolean isThreeDigit(String userNumber) {
        if (userNumber.length() == USER_NUMBER_LENGTH) {
            return true;
        }
        throw new IllegalArgumentException(PLEASE_INPUT_THREE_DIGIT_NUMBER);
    }

    public static boolean isNonZero(String userNumber) {
        if (userNumber.contains(ZERO)) {
            throw new IllegalArgumentException(PLEASE_INPUT_NON_ZERO_NUMBER);
        }
        return true;
    }

    public static boolean isOneOrTwo(String userNumber) {
        if (userNumber.equals(ONE) || userNumber.equals(TWO)) {
            return true;
        }
        throw new IllegalArgumentException(PLEASE_INPUT_1_OR_2);
    }

    public static boolean isAllDifferntNumber(String userNumber) {
        char[] user = userNumber.toCharArray();
        for (int index = MIN; index < USER_NUMBER_LENGTH - 1; index++) {
            if (user[index] == user[index+1]) {
                throw new IllegalArgumentException(PLEASE_INPUT_ALL_DIFFERENT_NUMBER);
            }
        }
        if (user[MIN] == user[USER_NUMBER_LENGTH - 1]) {
            throw new IllegalArgumentException(PLEASE_INPUT_ALL_DIFFERENT_NUMBER);
        }
        return true;
    }
}
