package baseball.function;

import baseball.BallCountData;

import java.util.Scanner;

public class OutputResult {
    private static final String NOTHING = "낫싱";
    private static final String ALL_STRIKE = "3스트라이크" + "\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static int ballCount;
    private static int strikeCount;
    public static final int MIN = 0;
    public static final int MAX = 3;

    private OutputResult() {}

    public static boolean isGameOver(BallCountData ballCountData) {
        getCountData(ballCountData);
        if (isAllStrike(strikeCount)) {
            System.out.println(ALL_STRIKE);
            return true;
        }

        if (isNoneBallAndStrike(ballCount, strikeCount)) {
            System.out.println(NOTHING);
            return false;
        }
        printResult();
        return false;
    }

    private static void getCountData(BallCountData ballCountData) {
        ballCount = ballCountData.getBall();
        strikeCount = ballCountData.getStrike();
    }

    private static boolean isAllStrike(int strikeCount) {
        return strikeCount == MAX;
    }

    private static boolean isNoneBallAndStrike(int ballCount, int strikeCount) {
        return ballCount == MIN && strikeCount == MIN;
    }

    private static void printResult() {
        StringBuilder stringBuilder = new StringBuilder();

        if (ballCount != MIN) {
            stringBuilder.append(ballCount + "볼" + " ");
        }

        if (strikeCount != MIN) {
            stringBuilder.append(strikeCount + "스트라이크");
        }

        System.out.println(stringBuilder.toString());
    }
}
