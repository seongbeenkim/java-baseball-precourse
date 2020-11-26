package baseball.function;

import java.util.Scanner;

public class InputNumber {
    private static final String PLEASE_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String DO_YOU_WANT_TO_PLAY_AGAIN = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final Scanner scanner;

    public InputNumber(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputUserNumber() {
        System.out.print(PLEASE_INPUT_NUMBER);
        return scanner.nextLine();
    }

    public String inputRestartNumber() {
        System.out.print(DO_YOU_WANT_TO_PLAY_AGAIN);
        return scanner.nextLine();
    }
}