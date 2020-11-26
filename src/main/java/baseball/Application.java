package baseball;

import baseball.function.*;

import java.io.DataOutput;
import java.util.Scanner;

public class Application {
    private static String answer;
    private static String userNumber;
    private static String APP_STOP = "숫자 야구 게임을 종료합니다.";
    private static final int START = 1;
    private static int gameState = START;
    private static BallCountData ballCountData;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputNumber inputNumber = new InputNumber(scanner);

        do {
            gameState = startGame(inputNumber);
        } while (gameState == START);

        System.out.println(APP_STOP);
    }

    public static int startGame(InputNumber inputNumber) {
        answer = AnswerMaker.createAnswer();

        do {
            userNumber = getUserNumber(inputNumber);
            ballCountData = CountBall.count(userNumber, answer);
        } while (!OutputResult.isGameOver(ballCountData));

        return getRestartNumber(inputNumber);
    }

    public static String getUserNumber(InputNumber inputNumber) {
        String userNumber = inputNumber.inputUserNumber();

        try {

            if (Validator.isNaturalNumber(userNumber)
                    && Validator.isThreeDigit(userNumber)
                    && Validator.isNonZero(userNumber)
                    && Validator.isAllDifferntNumber(userNumber)) {
                return userNumber;
            }

            return getUserNumber(inputNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getUserNumber(inputNumber);
        }
    }

    public static int getRestartNumber(InputNumber inputNumber) {
        String userNumber = inputNumber.inputRestartNumber();

        try {

            if (Validator.isNaturalNumber(userNumber)
                    && Validator.isOneOrTwo(userNumber)) {
                return Integer.parseInt(userNumber);
            }

            return getRestartNumber(inputNumber);
        } catch (IllegalArgumentException e) {
            return getRestartNumber(inputNumber);
        }
    }
}
