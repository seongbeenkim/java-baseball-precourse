package baseball.function;

import baseball.BallCountData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountBall {
    private static final int MIN = 0;
    private static final int MAX = 3;
    private static int ballCount;
    private static int strikeCount;
    private static BallCountData ballCountData;

    private CountBall() {}

    public static BallCountData count(String userNumber, String answerNumber) {
        ballCountData = new BallCountData();
        clearCount();
        if (isAllStrike(userNumber, answerNumber)) {
            ballCountData.setStrike(MAX);
            return ballCountData;
        }
        compareToAnswer(stringToList(userNumber), stringToList(answerNumber));
        return ballCountData;
    }

    private static void clearCount() {
        ballCount = MIN;
        strikeCount = MIN;
    }

    private static boolean isAllStrike(String userNumber, String answerNumber) {
        return userNumber.equals(answerNumber);
    }

    private static void compareToAnswer(List<String> userNumber, List<String> answerNumber) {

        for (int index = MIN; index < MAX; index++) {

            if (answerNumber.get(index).equals(userNumber.get(index))) {
                strikeCount++;
                continue;
            }

            if (answerNumber.contains(userNumber.get(index))) {
                ballCount++;
            }
        }

        ballCountData.setStrike(strikeCount);
        ballCountData.setBall(ballCount);
    }

    private static List<String> stringToList(String number) {
        return new ArrayList<String>(Arrays.asList(number.split("")));
    }
}
