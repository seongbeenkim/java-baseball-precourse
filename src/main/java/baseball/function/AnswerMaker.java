package baseball.function;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class AnswerMaker {
    private static final int MAX = 9;
    private static final int ANSWER_LENGTH = 3;
    private static final Random RANDOM = new Random();

    private AnswerMaker() {
    }

    public static String createAnswer() {
        List<Integer> answer = new ArrayList<Integer>();
        while (answer.size() != ANSWER_LENGTH) {
            addNumber(answer);
        }
        return answer.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private static void addNumber(List<Integer> answer) {
        try {
            int newNumber = RandomUtils.nextInt(RANDOM.nextInt(MAX) + 1, RANDOM.nextInt(MAX) + 1);
            if (!isNewNumberUsedBefore(answer, newNumber)) {
                answer.add(newNumber);
            }
        } catch (IllegalArgumentException e) {}
    }

    private static boolean isNewNumberUsedBefore(List<Integer> answer, int newNumber) {
        return answer.contains(newNumber);
    }
}
